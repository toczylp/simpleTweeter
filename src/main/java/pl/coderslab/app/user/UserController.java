package pl.coderslab.app.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.tweet.Tweet;
import pl.coderslab.app.tweet.TweetRepository;
import pl.coderslab.app.user.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    public UserController(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/{id}/tweets")
    public String addTweet(@PathVariable Long id, Model model) {
        model.addAttribute("tweets", tweetRepository.findAllByUserId(id));
        Tweet tweet = new Tweet();
        tweet.setUser(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
        model.addAttribute("tweet", tweet);
        return "tweets/tweets";
    }
    @PostMapping("/{id}/tweets")
    public String addTweet(@ModelAttribute @Valid Tweet tweet, BindingResult result) {
/*        if (result.hasErrors()) {
            return "tweets/tweets";
        }*/
        tweetRepository.save(tweet);
        return "redirect:../{id}/tweets";
    }
}