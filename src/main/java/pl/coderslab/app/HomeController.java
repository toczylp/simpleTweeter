package pl.coderslab.app;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.tweet.TweetRepository;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserNotFoundException;
import pl.coderslab.app.user.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public HomeController(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("tweets",tweetRepository.findAllOrderDesc());
        return "home";
    }
    @PostMapping("/home")
    public String home(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        User userDb = userRepository.findByEmail(user.getEmail()).orElseThrow(UserNotFoundException::new);
        if (result.hasErrors() || !BCrypt.checkpw(user.getPassword(), userDb.getPassword())) {
            model.addAttribute("error", "pwdMismatch");
            return "home";
        }

        if(result.hasErrors() || userDb.getPassword().equals(user.getPassword())) {
            model.addAttribute("error", "pwdMismatch");
            return "home";
        }
        return "redirect:user/" + userDb.getId() + "/tweets";
    }
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "register/signup";
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute @Valid User user, BindingResult result) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        if(result.hasErrors()) {
            return "register/signup";
        }
        userRepository.save(user);
        return "redirect:home";
    }
}
