package yunxin;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {
    @Test
    public void shouldReturnToken() throws Exception {
        Token yunToken = new Token();
        JSONObject token =  new JSONObject(yunToken.getToken());
        assertEquals(200, token.get("code"));
    }
}