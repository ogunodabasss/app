package com.example.backend.utils;

import org.springframework.http.HttpMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class RequestUtil {

    public static String getRequest(String uri, Map<String, String> parameters) {

        URL url;
        try {
            url = new URL(uri+ "?" + ParameterStringBuilder.getParamsString(parameters));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(HttpMethod.GET.name());
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Connection", "keep-alive");
            con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            con.setRequestProperty("Accept", "*/*");

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setDoOutput(true);

            int status = con.getResponseCode();
            if (status == 200 || status == 201) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                return content.toString();
            } else {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                throw new RuntimeException("err status: " + status + "\nMessage: " + content);
            }
        } catch (Throwable e) {
            if (con != null)
                con.disconnect();
            throw new RuntimeException(e);
        }
    }

    public static String getRequest(String uri) {

        URL url;
        try {
            url = new URL(uri);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(HttpMethod.GET.name());
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Connection", "keep-alive");
            con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            con.setRequestProperty("Accept", "*/*");

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setDoOutput(true);

            int status = con.getResponseCode();
            if (status == 200 || status == 201) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                return content.toString();
            } else {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                throw new RuntimeException("err status: " + status + "\nMessage: " + content);
            }
        } catch (Throwable e) {
            if (con != null)
                con.disconnect();
            throw new RuntimeException(e);
        }
    }
}
