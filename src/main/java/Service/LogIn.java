package Service;

import Client.Users;
import Utils.PasswordUtils;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static Utils.PasswordUtils.verifyPassword;

public class LogIn {

    public LogIn() {
    }

    public boolean login(String userName, String password, Users users) {
        return users.toString().contains(userName) & users.toString().contains(password);
    }


    public boolean loginUser(String userName, String password, Users users, User user) {
        for (Object userItem : users.getUsers()) {

            String key = PasswordUtils.hashPassword(user.getPassword(), user.getSalt()).get();

            if (userItem.equals(PasswordUtils.hashPassword(user.getPassword(), user.getSalt()).get())
                    && PasswordUtils.verifyPassword(password, key, user.getSalt())) {
                user.destroyPassword();
                return true;

            }
        }
        return false;
    }

    public void destroyUserPasswordString(User user) {
        user.destroyPassword();
    }


}
