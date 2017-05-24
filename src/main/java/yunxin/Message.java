package yunxin;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Message {
    public JSONObject sendGroup(String accountId, String groupId, String message) throws IOException {
        String url = "msg/sendMsg.action";
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(){{
            add(new BasicNameValuePair("from", accountId));
            add(new BasicNameValuePair("ope", "1"));
            add(new BasicNameValuePair("to", groupId));
            add(new BasicNameValuePair("type", "0"));
            add(new BasicNameValuePair("body", String.format("{\"msg\": \"%s\"}", message)));
        }};
        return Frame.request(url, parameters);
    }
}
