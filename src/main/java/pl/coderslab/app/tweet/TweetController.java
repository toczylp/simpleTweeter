package pl.coderslab.app.tweet;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.comment.Comment;
import pl.coderslab.app.comment.CommentRepository;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/tweet")
public class TweetController {
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;
    private final CommentRepository commentRepository;

    public TweetController(UserRepository userRepository, TweetRepository tweetRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/{id}")
    public String addComment(@PathVariable Long id, Model model) {
        Tweet tweet = tweetRepository.findById(id).orElseThrow(TweetNotFoundException::new);
        model.addAttribute("tweet", tweet);
        model.addAttribute("comments", commentRepository.findAllByTweetIdOrderByCreatedDesc(id));
        Comment comment = new Comment();
        comment.setTweet(tweet);
        model.addAttribute("comment", comment);
        return "tweets/tweet";
    }
    @PostMapping("/{id}")
    public String addComment(@ModelAttribute @Valid Comment comment, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "tweets/tweet";
        }
        comment.setId(null);
        commentRepository.save(comment);
        return "redirect:../tweet/" + id;
    }

    @ModelAttribute("users")
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
