package by.it.academy.services;

import by.it.academy.enteties.User;

import java.util.List;

public interface UserService {
    void createUser(String firstname, String secondname, String login, int age, int password);//User

    List<User> readUsers();
}
