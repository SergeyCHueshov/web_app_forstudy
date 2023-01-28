package by.it.academy.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //приколюха ломбока, содержащая конструктор и аксессоры;
@NoArgsConstructor// ломбок-конструктор без параметров;
@AllArgsConstructor //ломбок-конструктор с полями;
public class User {
    private String firstname;
    private String secondname;
    private String login;
    private int age;
    private int password;


}