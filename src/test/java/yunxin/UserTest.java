package yunxin;

import org.json.JSONObject;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void shouldReturn200WhenCreateUser() throws Exception {
        User user = new User();
        JSONObject newUser = user.create("test".concat(String.valueOf(UUID.randomUUID())).substring(0, 32));
        assertEquals(200, newUser.get("code"));
    }
}