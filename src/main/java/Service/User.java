package Service;

import Rights.Resources;
import Rights.Rights;

public class User {
    private String userName;
    private String password;
    private String salt;
    private String hashedPassword;
    private String token;

    private Rights accountRights;
    private Resources provisionResource;


    public User (String userName, String password, String salt) {
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }


    public User(String userName, String password, String salt, Rights accountRights, Resources provisionResource) {
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.accountRights = accountRights;
        this.provisionResource = provisionResource;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void destroyPassword() {
        this.password = "\000";
    }

    public String getSalt() {
        return salt;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public Rights getAccountRights() {
        return accountRights;
    }

    public Resources getProvisionResource() {
        return provisionResource;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    @Override
    public String toString() {
        return userName.toString() + ":" + password.toString();
    }


}
