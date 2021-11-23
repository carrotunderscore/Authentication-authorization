import Client.Users;
import Service.LogIn;

import Service.User;
import Utils.PasswordUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;


public class LoginTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    void test_check_usernamePassword_return_token() throws Exception {
        Users users = new Users();
        User user1 = new User("Kalle", "losen", PasswordUtils.generateSalt(15).toString());
        User user2 = new User("Berit", "123456", PasswordUtils.generateSalt(15).toString());
        User user3 = new User("Anna", "password", PasswordUtils.generateSalt(15).toString());

        String key1 = PasswordUtils.hashPassword(user1.getPassword(), user1.getSalt()).get();
        String key2 = PasswordUtils.hashPassword(user2.getPassword(), user2.getSalt()).get();
        String key3 = PasswordUtils.hashPassword(user3.getPassword(), user3.getSalt()).get();

        users.addUsers(user1.getUsername() + ":" + key1);
        users.addUsers(user2.getUsername() + ":" + key2);
        users.addUsers(user3.getUsername() + ":" + key3);
        LogIn login = new LogIn();

        Assertions.assertTrue(login.isUUID("HEJ"));
        Assertions.assertTrue(login.isUUID(login.loginUser("Kalle", "losen", users, user1)));

        //System.out.println(user1.getPassword());
    }


}
