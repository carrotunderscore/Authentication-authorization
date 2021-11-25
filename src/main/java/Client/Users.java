package Client;

import Service.User;
import Utils.PasswordUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Users {
    List<Object> users;

    public Users() {
        this.users = new ArrayList<Object>();
    }

    public List<Object> getUsers() {
        return users;
    }

    public void add(Object user) {
        users.add(user);
    }

    @Override
    public String toString() {
        for (Object user : users) {
            return users.toString();
        }
        return null;
    }
    public User addUserHash(String username, String password, User user){
        String salt = PasswordUtils.generateSalt(15).orElse(null);
        assert salt != null;

        String hashedPassword = PasswordUtils.hashPassword(password, salt).orElse(null);
        assert hashedPassword != null;
        user.setHashedPassword(hashedPassword);
        user.destroyPassword();

        return new User(username, hashedPassword, salt);
    }
}

