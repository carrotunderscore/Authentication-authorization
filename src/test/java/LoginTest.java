import Client.Users;
import Injector.Injector;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Map;

public class LoginTest {

    @Test
    public void test_return_user_map_size(){
        Injector injector = new Injector();

        Map map = injector.inject();
        assertThat(map.size(), is(3));
    }

    @ParameterizedTest
    @CsvSource({
            "Kalle, Berit, Anna"
    })
    public void test_return_user_map_users(String userKey){
        Injector injector = new Injector();

        Map map = injector.inject();
        Assert.assertNotNull(map);

        assertTrue(map.containsKey(userKey));

        System.out.println(map.keySet());
    }
    @ParameterizedTest
    @CsvSource({
            "losen, 123456, password"
    })
    public void test_return_user_map_passwords(String userValues){
        Injector injector = new Injector();

        Map map = injector.inject();
        Assert.assertNotNull(map);

        assertTrue(map.containsValue(userValues));

        System.out.println(map.values());
    }


}
