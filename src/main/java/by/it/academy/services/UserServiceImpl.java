package by.it.academy.services;

import by.it.academy.enteties.User;
import by.it.academy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor //ломбок-конструктор, необходимый UserRepository;
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(String firstname, String secondname, String login, int age, int password) {
        userRepository.createUser(firstname, secondname, login, age, password);
    }

    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();//вызываю UserRepository для того, чтобы получить список юзеров;
    }
}
