package by.it.academy.repositories;

import by.it.academy.enteties.User;
import by.it.academy.enteties.UserType;

import java.util.List;

public interface UserRepository {
    User createUser(String firstname, String secondname, String login, int age, int password, UserType userType);

    List<User> readUsers();
}
