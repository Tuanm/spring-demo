package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import repository.Repository;
import repository.UserRepository;

@Component
public class UserLogin {
    @Autowired
    @Qualifier(value = "UserRepository")
    private static Repository<User> userRepository;

    static {
        userRepository = UserRepository.INSTANCE; // @Autowired doesn't work
    }

    public static User login(String username, String password) {
        return userRepository.first(other ->
            other.username.equals(username)
                    && other.password.equals(password));
    }
}
