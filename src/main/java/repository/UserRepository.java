package repository;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component(value = "UserRepository")
public class UserRepository implements Repository<User> {
    @Autowired
    private Map<String, User> users;

    public static UserRepository INSTANCE = new UserRepository(); // @Autowired doesn't work

    public UserRepository() {
        users = new HashMap<>(); // @Autowired doesn't work
    }

    @Override
    public boolean add(User user) {
        if (user == null) return false;
        String username = user.username;
        if (!users.containsKey(username)) {
            users.put(username, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Predicate<User>... predicates) {
        User found = first(predicates);
        if (found != null) {
            users.remove(found.username);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user, Predicate<User>... predicates) {
        if (user == null) return false;
        User found = first(predicates);
        if (found != null) {
            String username = user.username;
            if (!username.equals(found.username)) return false;
            users.put(username, user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> find(Predicate<User>... predicates) {
        Stream<User> found = users.values().stream();
        for (Predicate<User> predicate : predicates) {
            found = found.filter(predicate);
        }
        return found.collect(Collectors.toList());
    }

    @Override
    public User first(Predicate<User>... predicates) {
        List<User> found = find(predicates);
        if (!found.isEmpty()) return found.get(0);
        return null;
    }
}
