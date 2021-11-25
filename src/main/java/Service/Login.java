package Service;

import Client.Users;

import java.util.UUID;

public class Login {
    String uuidString;
    String token;

    public Login() {
    }

    public String checkLoginUser(User user, Users users) throws Exception {
        boolean userExists = false;
        String userCredentials = user.getUsername() + ":" + user.getHashedPassword();
        for(Object userItem : users.getUsers()){
            //System.out.println(userItem);
            //System.out.println(userCredentials);
            if(userCredentials.equals(userItem.toString())){
                userExists = true;
                UUID uuid = UUID.randomUUID();
                String uuidString = uuid.toString();
                token = uuidString;
            }
        }
        if(userExists){
            user.destroyPassword();
            return token;
        }
        else{
            throw new Exception();
        }
    }

    public static boolean isUUID(String string) {
        try {
            UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }





}
