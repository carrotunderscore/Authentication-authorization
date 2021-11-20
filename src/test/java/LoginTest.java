import Client.Users;
import Service.LogIn;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LoginTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    void test_check_user_login() {
        Users users = new Users();
        users.addUsers(new User("Kalle", "losen"));
        users.addUsers(new User("Berit", "123456"));
        users.addUsers(new User("Anna", "password"));

        LogIn login = new LogIn();
        System.out.println(login.login("Berit", "123456", users));

    }

    @ParameterizedTest
    @CsvSource({"Kalle,losen", "Berit,123456", "Anna, password"})
    void test_check_table_of_users(String username, String password) {
        Users users = new Users();
        users.addUsers(new User("Kalle", "losen"));
        users.addUsers(new User("Berit", "123456"));
        users.addUsers(new User("Anna", "password"));
        LogIn login = new LogIn();
        ;
        Assert.assertEquals(true, login.login(username, password, users));

    }


}
