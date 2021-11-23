package Service;

import Client.Users;
import Utils.PasswordUtils;

import java.util.UUID;

public class LogIn {
    String uuidString;

    public LogIn() {
    }

    public String loginUser(String userName, String password, Users users, User user) throws Exception {
        boolean userExists = false;
        for (Object userItem : users.getUsers()) {
            String[] userItemSplit = userItem.toString().split(":");
            String key = PasswordUtils.hashPassword(user.getPassword(), user.getSalt()).get();
            if (userItemSplit[0].equals(userName)
                    && userItemSplit[1].equals(PasswordUtils.hashPassword(user.getPassword(), user.getSalt()).get())
                    && PasswordUtils.verifyPassword(password, key, user.getSalt())) {
                user.destroyPassword();
                UUID uuid = UUID.randomUUID();
                String uuidString = uuid.toString();
                System.out.println(uuidString);
                userExists = true;
                return uuidString;
            }
        }
        if (userExists) {
            return uuidString;
        } else {
            throw new Exception();
        }
    }

    public boolean isUUID(String string) {
        try {
            UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
