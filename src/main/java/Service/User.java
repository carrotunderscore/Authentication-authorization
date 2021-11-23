package Service;

import Client.Users;
import Utils.PasswordUtils;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String salt;

    public User(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void destroyPassword(){
        this.password = "\000";
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return username.toString() + ":" + password.toString();
    }


}
