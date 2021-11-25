package Service;

import Client.Users;
import Utils.PasswordUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Login {
    String uuidString;
    List<String> token;

    public Login() {
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
            List<String> token = new ArrayList<>();
            token.add(uuidString);
            return uuidString;
        } else {
            throw new Exception();
        }
    }

    public static boolean checkLoginUser(User user, Users users){
        boolean userExists = false;
        String userCredentials = user.getUsername() + ":" + user.getHashedPassword();
        for(Object userItem : users.getUsers()){
            //System.out.println(userItem);
            //System.out.println(userCredentials);
            if(userCredentials.equals(userItem.toString())){
                userExists = true;
            }
        }
        if(userExists){
            user.destroyPassword();
        }
        return userExists;
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
