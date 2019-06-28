package com.ivan.mengfzsearch.utils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人：WUHUI
 * @创建时间：2019-3-26
 * @描述：
 **/
public class HttpRequestUtil {

    /*
     *
     * 创建get请求
     *
     * */

    public static String doGet(String url, Map<String,String> reqMap) {

        //保存请求结果
        String result = "";

        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //设置请求参数
        try {
            URIBuilder builder = new URIBuilder(url);
            for (String key : reqMap.keySet()) {
                builder.addParameter(key, reqMap.get(key));
            }
            URI reqUrl = builder.build();

            //创建http请求
            HttpGet get = new HttpGet(reqUrl);

            //执行请求，获得响应
            CloseableHttpResponse response = httpClient.execute(get);
            //获取响应中的内容
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回信息
        return result;
    }

    /*
     *
     * 创建post请求
     *
     * */

    public static String doPost(String url, Map<String, String> reqMap) {

        //保存请求的结果
        String result = "";

        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //设置请求参数
        List<NameValuePair> paramList = new ArrayList<>();
        for (String key : reqMap.keySet()) {
            paramList.add(new BasicNameValuePair(key, reqMap.get(key)));
        }

        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);

            //创建post请求
            HttpPost post = new HttpPost(url);
            post.setEntity(entity);

            //执行请求
            CloseableHttpResponse response = httpClient.execute(post);

            result = EntityUtils.toString(response.getEntity(), "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }


}
