package Client;

import Rights.Rights;
import Service.User;
import Utils.PasswordUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Rights.Resources;


public class Users {
    List<Object> users;
    List<String> tokens;
    private Rights accountRights;
    private Resources provisionResource;
    HashMap<List<Object>, Resources> userRightsHashMap;

    public Users() {
        this.users = new ArrayList<Object>();
        this.tokens = new ArrayList<String>();
        this.userRightsHashMap = new HashMap<List<Object>, Resources>();
    }

    public List<Object> getUsers() {
        return users;
    }
    public List<String> getTokens() {
        return tokens;
    }

    public void setAccountRights(Rights accountRights) {
        this.accountRights = accountRights;
    }

    public void setProvisionResource(Resources provisionResource) {
        this.provisionResource = provisionResource;
    }

    public Rights getAccountRights() {
        return accountRights;
    }

    public Resources getProvisionResource() {
        return provisionResource;
    }

    public void add(Object user, Resources resource) {
        users.add(user);
        userRightsHashMap.put(this.users, resource);
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

    public void addUserToken(String token){
        tokens.add(token);
    }
    public Object userRights(String token, Resources resource) {
        for (Object userItem : this.getTokens()) {
            if (token.equals(userItem)) {
                System.out.println(userItem);
                switch (resource) {
                    case ACCOUNT:
                        System.out.println(" <" + resource + "> " + this.getAccountRights());
                        return this.getAccountRights();
                    case PROVISION_CALC:
                        System.out.println(" <" + resource + "> " + this.getProvisionResource());
                        return getProvisionResource();
                }
            }

        }
        return null;
    }
}

