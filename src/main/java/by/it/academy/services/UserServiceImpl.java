package by.it.academy.services;

import by.it.academy.enteties.User;
import by.it.academy.enteties.UserType;
import by.it.academy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public void createUser(String firstname, String secondname, int age, String login, String password, UserType userType) {
        userRepository.createUser(firstname, secondname, age, login, password, userType);
    }
    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();//вызываю UserRepository для того, чтобы получить список юзеров;
    }
}
