package kr.co.huxx.parser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {
    private static String address;
    private static URL url;
    private static BufferedReader bufferedReader;
    private static HttpURLConnection httpURLConnection;
    private static String protocol = "GET";

    public static void main(String[] args) throws IOException {
        address = "http://news.naver.com/main/read.nhn?mode=LPOD&mid=sec&oid=001&aid=0010007160&isYeonhapFlash=Y&rc=N";
        try {
            url = new URL(address);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod(protocol);
            httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0");
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"euc-kr"));
            String temp;
            String input = "";
            while ((temp=bufferedReader.readLine())!=null) {
                System.out.println(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        bufferedReader.close();

    }

}
