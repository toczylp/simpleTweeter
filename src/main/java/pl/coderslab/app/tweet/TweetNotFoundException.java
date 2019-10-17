package pl.coderslab.app.tweet;

public class TweetNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Tweet not fount";
    }
}
