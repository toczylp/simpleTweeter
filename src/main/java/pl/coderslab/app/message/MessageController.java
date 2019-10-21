package pl.coderslab.app.message;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserRepository;

@Controller
@RequestMapping("/message")
public class MessageController {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageController(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{id}")
    public String add(@PathVariable Long id, Model model) {
        Message message = new Message();
        message.setSender(userRepository.getOne(id));
        model.addAttribute("new_message", new Message());
        model.addAttribute("sent_message", messageRepository.findAllBySenderIdOrderByCreatedDesc(id));
        model.addAttribute("received_message", messageRepository.findAllByRecipientIdOrderByCreatedDesc(id));
        return "messages/messages";
    }
    @PostMapping("/user/{id}")
    public String add(@PathVariable Long id, @ModelAttribute Message new_message, Model model) {
        new_message.setId(null);
        new_message.setSender(userRepository.getOne(id));
        if (new_message.getRecipient().getId() == new_message.getSender().getId()) {
            model.addAttribute("errorMsg", "recipientError");
            return "redirect:../user/" + id;
        }
        messageRepository.save(new_message);
        return "redirect:../user/" + id;
    }

    @GetMapping("/read/{id}")
    public String read(@PathVariable Long id) {
        Message message = messageRepository.findById(id).orElseThrow(RuntimeException::new);
        message.setReadFlag(true);
        messageRepository.save(message);
        return "redirect:../user/" + message.getRecipient().getId();
    }

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
