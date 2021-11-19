package Injector;

import Client.Users;
import Service.LogIn;

import java.util.HashMap;
import java.util.Map;

interface hashmapObject{
    void hashmap(Map<Object, Object> hashmapObject);
}

public class Injector {
    public Map inject() {
        Users users = new Users();
        Map<String, String> userMap = users.initializeUsers();

        LogIn login = new LogIn();
        login.checkUserName("Kalle", userMap);

        return users.initializeUsers();
    }
}
