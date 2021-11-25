import Client.Users;
import Rights.Permissions;
import Rights.Resources;
import Service.Login;

import Service.User;
import Utils.PasswordUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest {

    @BeforeEach
    public void setUp() {
        Login login = new Login();
    }

    // EGENSKAP 2: Autentisering
    @ParameterizedTest
    @CsvSource({
            "Anna, losen",
            "Berit, 123456",
            "Kalle, password"
    })
    void test_login_return_token_check_uuid(String username, String password) throws Exception {
        Users users = new Users();
        User user = new User(username, password, PasswordUtils.generateSalt(15).toString());
        users.add(users.addUserHash(username, password, user));
        Login login = new Login();

        //RÖTT TEST
        //Assertions.assertTrue(Login.isUUID("INTE UUID"));

        Assertions.assertTrue(Login.isUUID(login.checkLoginUser(user, users)));

    }


    @Test
    void test_exception_thrown_on_wrong_user() throws Exception {
        Users users = new Users();
        User user = new User("Kalle_not_existing_in_users", "password",
                PasswordUtils.generateSalt(15).toString());

        // RÖTT TEST
        //User realUser = new User("Kalle", "password", PasswordUtils.generateSalt(15).toString());
        //users.add(users.addUserHash("Kalle", "password", realUser));
        //checkException(realUser, users);

        checkException(user, users);
    }

    //Called by test method above
    void checkException(User user, Users users){
        Throwable e = null;
        try {
            Login login = new Login();
            login.checkLoginUser(user, users);
        } catch (Throwable ex) {
            e = ex;
        }
        Assertions.assertTrue(e instanceof Exception);
    }







    /*
     * User=username, password, salt
     * Login=username + hashedpassword = password + salt
     * if(user + hashedpassword ){
     *   Users.add(users)
     * }
     *
     * return token from correct login
     * verify token
     *
     * input token + resource = output rights
     *
     *
     * */


}
