package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import repository.Repository;
import repository.UserRepository;

@Component
public class UserRegister {
    @Autowired
    @Qualifier(value = "UserRepository")
    private static Repository<User> userRepository;

    static {
        userRepository = UserRepository.INSTANCE; // @Autowired doesn't work
    }

    public static boolean hasExisted(User user) {
        return userRepository.first(other ->
                other.username.equals(user.username)) == null;
    }

    public static boolean tryRegister(User user) {
        return userRepository.add(user);
    }
}
