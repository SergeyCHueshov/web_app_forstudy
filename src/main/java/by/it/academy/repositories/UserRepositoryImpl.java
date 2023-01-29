package by.it.academy.repositories;

import by.it.academy.enteties.User;
import by.it.academy.enteties.UserType;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;
    public UserRepositoryImpl(List<User> users) {
        this.users = users;
    }
    @Override
    public User createUser(String firstname, String secondname, int age, String login, String password, UserType userType) {
        User user = new User();
        users.add(user);
        return user;
    }
    @Override
    public List<User> readUsers() {
        return users;
    }

}
