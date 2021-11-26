import Client.Users;
import Rights.Rights;
import Service.Login;

import Service.User;
import Utils.PasswordUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import Rights.Resources;

import static org.junit.jupiter.api.Assertions.*;


public class LoginTest {

    @BeforeEach
    public void setUp() {
        Login login = new Login();
    }
    // EGENSKAP 3: Rättigheter
    @ParameterizedTest
    @CsvSource({
            "Anna, losen",
            "Berit, 123456",
            "Kalle, password"
    })
    void test_check_token_rights(String username, String password) throws Exception {
        Users users = new Users();
        User user = new User(username, password, PasswordUtils.generateSalt(15).toString(),
                Rights.READ, Resources.ACCOUNT);

        users.add(users.addUserHash(username, password, user),
                user.getProvisionResource());
        users.setAccountRights(user.getAccountRights());
        users.setProvisionResource(user.getProvisionResource());

        Login login = new Login();
        String token = login.giveUserToken(user, users);

        user.setToken(token);
        users.addUserToken(token);

        User user1 = new User("username", password, PasswordUtils.generateSalt(15).toString());

        // RÖTT TEST
        //Assertions.assertNotNull(users.userRights(token, Resources.PROVISION_CALC));

        Assertions.assertNotNull(users.userRights(token, Resources.PROVISION_CALC));
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
        User user = new User(username, password, PasswordUtils.generateSalt(15).toString(),
                Rights.READ, Resources.ACCOUNT);
        users.add(users.addUserHash(username, password, user), Resources.ACCOUNT);
        Login login = new Login();

        //RÖTT TEST
        //Assertions.assertTrue(Login.isUUID("INTE UUID"));
        String token = login.giveUserToken(user, users);
        Assertions.assertTrue(Login.isUUID(token));
    }

    @Test
    void test_exception_thrown_on_wrong_user() throws Exception {
        Users users = new Users();
        User user = new User("Kalle_not_existing_in_users", "password",
                PasswordUtils.generateSalt(15).toString(), Rights.READ, Resources.ACCOUNT);

        // RÖTT TEST
        //User realUser = new User("Kalle", "password", PasswordUtils.generateSalt(15).toString());
        //users.add(users.addUserHash("Kalle", "password", realUser));
        //checkException(realUser, users);

        checkException(user, users);
    }

    @ParameterizedTest
    @CsvSource({
            "Anna, losen",
            "Berit, 123456",
            "Kalle, password"
    })
    void test_destroy_user_password_string(String username, String password){
        Users users = new Users();
        User user = new User(username, password,
                PasswordUtils.generateSalt(15).toString(), Rights.READ, Resources.ACCOUNT);
        Login.destroyUserPasswordString(user);
        Assertions.assertEquals("\000", user.getPassword());

    }

    //Called by test method above
    void checkException(User user, Users users){
        Throwable e = null;
        try {
            Login login = new Login();
            login.giveUserToken(user, users);
        } catch (Throwable ex) {
            e = ex;
        }
        Assertions.assertTrue(e instanceof Exception);
    }

}
