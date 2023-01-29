package by.it.academy.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstname;
    private String secondname;
    private String login;
    private int age;
    private int password;
    private UserType userType;
}