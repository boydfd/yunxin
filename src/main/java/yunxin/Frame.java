package yunxin;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.List;

class Frame {
    static JSONObject request(String url, String contentType, List<NameValuePair> parameters) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String fullUrl = "https://api.netease.im/nimserver/".concat(url);
        HttpPost httpPost = new HttpPost(fullUrl);

        Frame.setHeaders(httpPost, contentType);
        httpPost.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
        HttpResponse response = httpClient.execute(httpPost);
        return new JSONObject(EntityUtils.toString(response.getEntity(), "utf-8"));
    }

    private static void setHeaders(HttpPost httpPost, String contentType) {
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String appKey = System.getenv("APP_KEY");
        String appSecret = System.getenv("APP_SECRET");
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", contentType);
    }
}
