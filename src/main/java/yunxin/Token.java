package yunxin;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Token {
    public JSONObject getToken() throws IOException {
        String contentType = "application/x-www-form-urlencoded;charset=utf-8";
        String url = "user/refreshToken.action";
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(){{
            add(new BasicNameValuePair("accid", "boydfd"));
        }};
        return Frame.request(url, contentType, parameters);
    }

}
