package yunxin;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Token {
    public String getToken() throws Exception{
        HttpClient httpClient = HttpClientBuilder.create().build();
        String url = "https://api.netease.im/nimserver/user/refreshToken.action";
        HttpPost httpPost = new HttpPost(url);

        String appKey = System.getenv("APP_KEY");
        String appSecret = System.getenv("APP_SECRET");
        String nonce =  "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String contentType = "application/x-www-form-urlencoded;charset=utf-8";

        setHeaders(httpPost, appKey, appSecret, nonce, curTime, contentType);

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", "boydfd"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    private void setHeaders(HttpPost httpPost, String appKey, String appSecret, String nonce, String curTime, String contentType) {
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", contentType);
    }
}
