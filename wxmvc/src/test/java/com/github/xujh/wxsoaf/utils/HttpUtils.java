package com.github.xujh.wxsoaf.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpUtils {

    public static String sendGet(String url, final String content) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        // 创建GET方法的实�?
        HttpPost httpPost = new HttpPost(url);

        // StringEntity reqEntity = null;
        // try {
        // reqEntity = new StringEntity(content);
        // } catch (UnsupportedEncodingException e1) {
        // // TODO Auto-generated catch block
        // e1.printStackTrace();
        // }
        //
        // // 设置类型
        //
        // reqEntity.setContentType("application/x-www-form-urlencoded");

        // 设置请求的数�?

        // httpPost.setEntity(reqEntity);

        // 使用系统提供的默认的恢复策略
        // httpPost.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
        // new DefaultHttpMethodRetryHandler());
        StringBuilder sb = new StringBuilder();
        try {
            // 执行getMethod

            ContentProducer cp = new ContentProducer() {
                public void writeTo(OutputStream outstream) throws IOException {
                    Writer writer = new OutputStreamWriter(outstream, "UTF-8");
                    writer.write(content);
                    writer.flush();
                }
            };

            httpPost.setEntity(new EntityTemplate(cp));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            System.out.println(response.getStatusLine());
            // 显示结果
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(),
                    "UTF-8"));

            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
                System.out.println(line);
            }

            if (entity != null) {
                entity.consumeContent();
            }
        } finally {
            // 释放连接
            httpPost.releaseConnection();
        }

        return sb.toString();
    }
}
