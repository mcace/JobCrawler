package com.mcsoft.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * 提取页面工具类
 * Created by Mc on 2017/12/7.
 */
public class PageLoader {
    public static String loadPage(String url) {
        return loadPage(url, "GET", null, null);
    }

    public static String loadPage(String url, String method, Map<String, String> headers, String
            body) {
        String response = "";
        ByteArrayOutputStream baos = null;
        DataOutputStream outputStream = null;
        InputStream is = null;
        HttpURLConnection connection = null;
        try {
            if (!url.startsWith("http://") && !url.startsWith("https://"))
                url = "http://" + url;
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            connection = (HttpURLConnection) realUrl.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            if (null == method || "".equals(method)) method = "GET";
            connection.setRequestMethod(method);
            if (null != headers && 0 != headers.size()) {
                for (Map.Entry<String, String> entry :
                        headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if (body != null && !body.equals("")) {
                outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.writeBytes(body);
                outputStream.flush();
            } else {
                // 建立实际的连接
                connection.connect();
            }
            // 获取所有响应头字段
            is = connection.getInputStream();       //以输入流的形式返回
            //将输入流转换成字符串
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            response = baos.toString();
            //获取SetCookie头进行设置Cookie
            String cookie = connection.getHeaderField("Set-Cookie");
            if (null != headers && null != cookie && !"".equals(cookie)) {
                headers.put("Cookie", cookie);
            }
            //System.out.println(connection.getHeaderField("Set-Cookie"));
            //System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) outputStream.close();
                if (baos != null) baos.close();
                if (is != null) is.close();
                if (connection != null) connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return response;
    }
}
