package Service;

import Client.Users;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class LogIn {

    public LogIn() {
    }

    public boolean login(String userName, String password, Users users) {
        return users.toString().contains(userName) & users.toString().contains(password);
    }

}
