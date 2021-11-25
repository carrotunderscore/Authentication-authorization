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


public class LoginTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    void test_check_usernamePassword_return_token() throws Exception {
        /*
        Users users = new Users();
        User user1 = new User("Kalle", "losen",
                PasswordUtils.generateSalt(15).toString());
        User user2 = new User("Berit", "123456",
                PasswordUtils.generateSalt(15).toString());
        User user3 = new User("Anna", "password",
                PasswordUtils.generateSalt(15).toString());

        user1.setAuthorization(Resources.ACCOUNT, Permissions.READ);
        user2.setAuthorization(Resources.PROVISION_CALC, Permissions.WRITE);
        user3.setAuthorization(Resources.ACCOUNT, Permissions.EXECUTABLE);

        System.out.println(user1.getAuthorization());
        System.out.println(user2.getAuthorization());
        System.out.println(user3.getAuthorization());

        String key1 = PasswordUtils.hashPassword(user1.getPassword(), user1.getSalt()).get();
        String key2 = PasswordUtils.hashPassword(user2.getPassword(), user2.getSalt()).get();
        String key3 = PasswordUtils.hashPassword(user3.getPassword(), user3.getSalt()).get();

        users.addUsers(user1.getUsername() + ":" + key1, Login.hashUserPassword(user1.getPassword(), user1.getSalt()));
        users.addUsers(user2.getUsername() + ":" + key2, Login.hashUserPassword(user1.getPassword(), user1.getSalt()));
        users.addUsers(user3.getUsername() + ":" + key3, Login.hashUserPassword(user1.getPassword(), user1.getSalt()));
        Login login = new Login();

        //Assertions.assertTrue(login.isUUID("HEJ"));
        Assertions.assertTrue(login.isUUID(login.loginUser("Kalle", "losen", users, user1)));

         */
    }

    @ParameterizedTest
    void test_login_user_with_encrypted_password_and_userToken_success(String username, String password) {
    }

    @Test
    void test_login_fail_with_exception() {

    }

    @ParameterizedTest
    @MethodSource("testData")
    void test_verify_user_token_success(String username, String password) {

    }

    @ParameterizedTest
    @CsvSource({
            "Anna, losen",
            "Berit, 123456",
            "Kalle, password"
    })
    // Egenskap 1: Inloggning
    void test_user_login(String username, String password)  {
        Users users = new Users();
        User user = new User(username, password, PasswordUtils.generateSalt(15).toString());
        users.add(users.addUserHash(user.getUsername(), user.getPassword(), user));
        Assertions.assertTrue(Login.checkLoginUser(user, users), "true");
    }

    @ParameterizedTest
    @CsvSource({
            "Anna, losen",
            "Berit, 123456",
            "Kalle, password"
    })
    void test_encrypted_password(String username, String password){
        User user = new User(username, password, PasswordUtils.generateSalt(15).toString());
        Users users = new Users();

        // RÖTT TEST
        //Assertions.assertEquals(password, user.getHashedPassword());

        users.addUserHash(username, password, user);
        Assertions.assertNotEquals(password, user.getHashedPassword());

    }

    @ParameterizedTest
    @CsvSource({
            "Anna, losen",
            "Berit, 123456",
            "Kalle, password"
    })
    void test_destroyed_password(String username, String password){
        User user = new User(username, password, PasswordUtils.generateSalt(15).toString());
        user.destroyPassword();

        // RÖTT TEST
        Assertions.assertEquals(password, user.getPassword());

        Assertions.assertEquals("\000", user.getPassword());

    }

    // EGENSKAP 2: Autentisering




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
