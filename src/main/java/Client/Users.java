package Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
    private String List;
    private String Map;

    public String getMap() {
        if(Map != null){
            return Map;
        }else{
            return null;
        }
    }

    public Users(){

    }

    public Map<String, String> initializeUsers(){
        java.util.Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("Anna", "losen");
        userMap.put("Berit", "123456");
        userMap.put("Kalle", "password");
        return userMap;
    }
}
