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
    void test_check_user_login() throws IOException {
        Users users = new Users();
        users.addUsers(new User("Kalle", "losen"));
        users.addUsers(new User("Berit", "123456"));
        users.addUsers(new User("Anna", "password"));

        LogIn login = new LogIn();
        System.out.println(login.login("Berit", "123456", users));

    }




}
