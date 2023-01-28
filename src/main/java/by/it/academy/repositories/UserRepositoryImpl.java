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
    public User createUser(String firstname, String secondname, String login, int age, int password, UserType userType) {
        User user = new User(firstname,secondname,login,age,password,userType);
        users.add(user);
        return user;
    }


    @Override
    public List<User> readUsers() {
        return users;
    }
}
