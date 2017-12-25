package com.mcsoft.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;

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
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
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

            //判断状态码
            if (!isStatusOK(connection.getResponseCode())) {
                return "";
            }

            // 获取压缩编码字段
            String contentEncoding = connection.getContentEncoding();
            // 处理压缩编码
            is = handleContentEncoding(contentEncoding, connection);

            //将输入流转换成字符串
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            response = baos.toString();

            //获取SetCookie头进行设置Cookie
            String cookie = connection.getHeaderField("Set-Cookie");
            if (null != headers && !"".equals(cookie)) {
                headers.put("Cookie", cookie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                if (outputStream != null) outputStream.close();
                if (is != null) is.close();
                if (connection != null) connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return response;
    }

    //处理状态码
    private static boolean isStatusOK(int statusCode) {
        statusCode = statusCode / 100;
        switch (statusCode) {
            case 3:
            case 4:
            case 5: {
                return false;
            }
            default: {
                return true;
            }
        }
    }

    //处理压缩字符
    private static InputStream handleContentEncoding(String contentEncoding, HttpURLConnection connection) throws IOException {
        switch (null == contentEncoding ? "" : contentEncoding) {
            case "gzip": {
                return new GZIPInputStream(connection.getInputStream());
            }
            case "deflate": {
                return new DeflaterInputStream(connection.getInputStream());
            }
            default: {
                return connection.getInputStream();       //以输入流的形式返回
            }
        }
    }
}
