package Service;

import Client.Users;
import Utils.PasswordUtils;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

import static Utils.PasswordUtils.verifyPassword;

public class LogIn {

    public LogIn() {
    }

    public boolean login(String userName, String password, Users users) {
        return users.toString().contains(userName) & users.toString().contains(password);
    }


    public boolean loginUser(String userName, String password, Users users, User user) throws Exception {
        boolean userExists = false;
        for (Object userItem : users.getUsers()) {

            String key = PasswordUtils.hashPassword(user.getPassword(), user.getSalt()).get();

            if (userItem.equals(PasswordUtils.hashPassword(user.getPassword(), user.getSalt()).get())
                    && PasswordUtils.verifyPassword(password, key, user.getSalt())) {
                user.destroyPassword();
                UUID uuid = UUID.randomUUID();
                String uuidString = uuid.toString();
                System.out.println(uuidString);
                userExists = true;
                break;
            }
        }
        if(userExists){
            return true;
        }
        else{
            throw new Exception();
        }
    }

    public void destroyUserPasswordString(User user) {
        user.destroyPassword();
    }




}
