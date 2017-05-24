package yunxin;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {

    public JSONObject create(String accountId) throws IOException {
        String url = "user/create.action";
        List<NameValuePair> parameters = new ArrayList<NameValuePair>() {{
            add(new BasicNameValuePair("accid", accountId));
        }};
        return Frame.request(url, parameters);
    }
}
