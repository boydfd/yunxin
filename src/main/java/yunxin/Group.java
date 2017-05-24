package yunxin;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {
    private String owner;

    Group(String owner) {
        this.owner = owner;
    }

    public JSONObject create(String members) throws IOException {
        String url = "team/create.action";
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(){{
            add(new BasicNameValuePair("tname", owner.concat(String.valueOf(UUID.randomUUID()))));
            add(new BasicNameValuePair("owner", owner));
            add(new BasicNameValuePair("members", members));
            add(new BasicNameValuePair("msg", "welcome"));
            add(new BasicNameValuePair("joinmode", "0"));
        }};
        return Frame.request(url, parameters);
    }
}
