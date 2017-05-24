package yunxin;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {
    @Test
    public void shouldReturn200WhenSendMessage() throws Exception {
        Message message = new Message();
        JSONObject response = message.sendGroup("boydfd", "46398194", "hello");
        assertEquals(200, response.get("code"));
    }
}