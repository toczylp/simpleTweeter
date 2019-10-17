package pl.coderslab.app.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class TweetConverter implements Converter<String, Tweet> {
    @Autowired
    private TweetRepository tweetRepository;
    @Override
    public Tweet convert(String s) {
        return tweetRepository.findById(Long.parseLong(s)).get();
    }
}
