package Service;

import Rights.Permissions;
import Rights.Resources;
import Utils.PasswordUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class User {
    private String username;
    private String password;
    private String salt;
    private String hashedPassword;
    HashMap<Resources, List<Permissions>> authorizations;

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
    public HashMap getAuthorization() {
        return authorizations;
    }
    public void setAuthorization(Resources resources, Permissions permissions) {
        authorizations.put(resources, List.of(permissions));
    }

    public void setHashedPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }
    public String getHashedPassword(){
        return hashedPassword;
    }

    @Override
    public String toString() {
        return username.toString() + ":" + password.toString();
    }


}
