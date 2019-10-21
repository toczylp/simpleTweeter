package pl.coderslab.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceContext;

@Component
public class UserConverter implements Converter<String, User> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User convert(String s) {
        return userRepository.findById(Long.parseLong(s)).orElseThrow(UserNotFoundException::new);
    }
}
