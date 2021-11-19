package Service;

import java.util.Map;
import java.util.Scanner;

public class LogIn {
    public LogIn(){
        System.out.println("Insert username");
    }

    public boolean checkUserName(String userName, Map<String, String> userMap){
        Boolean userNameExists = false;
        System.out.println("Insert username");
        return userMap.containsKey(userName);
    }

    public boolean password(){
        Boolean passwordExists = false;
        System.out.println("Insert password");
        Scanner passwordInput = new Scanner(System.in);
        return false;
    }

}
