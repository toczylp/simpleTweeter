package pl.coderslab.app.user;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<String, User> {
    private UserRepository userRepository;
    @Override
    public User convert(String s) {
        return userRepository.findById(Long.parseLong(s)).orElseThrow(UserNotFoundException::new);
    }
}
