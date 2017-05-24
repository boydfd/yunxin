package yunxin;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {
    @Test
    public void shouldReturn200WithTrueAccountId() throws Exception {
        Token yunToken = new Token();
        JSONObject token =  yunToken.getToken("boydfd");
        assertEquals(200, token.get("code"));
    }

    @Test
    public void shouldReturn404WithFalseAccountId() throws Exception {
        Token yunToken = new Token();
        JSONObject token =  yunToken.getToken("boydfd100");
        assertEquals(414, token.get("code"));
    }
}