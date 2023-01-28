package by.it.academy.services;

import by.it.academy.enteties.User;
import by.it.academy.enteties.UserType;

import java.util.List;

public interface UserService {
    void createUser(String firstname, String secondname, String login, int age, int password, UserType userType);//User

    List<User> readUsers();
}
