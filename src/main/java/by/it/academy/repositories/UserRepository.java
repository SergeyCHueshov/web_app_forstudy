package by.it.academy.repositories;

import by.it.academy.enteties.User;

import java.util.List;

public interface UserRepository {
    User createUser(String firstname, String secondname, String login, int age, int password);

    List<User> readUsers();
}
