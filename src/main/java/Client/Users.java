package Client;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Users {
    List<Object> users;

    public Users() {
        this.users = new ArrayList<Object>();
    }

    public List<Object> getUsers() {
        return users;
    }

    public void addUsers(Object user) {
        users.add(user);
    }

    @Override
    public String toString() {
        for (Object user : users) {
            return users.toString();
        }
        return null;
    }
}

