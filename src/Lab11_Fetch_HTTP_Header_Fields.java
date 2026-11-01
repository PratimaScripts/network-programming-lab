// Write a Java program to fetch all HTTP header fields using URLConnection.

import java.net.*;
import java.util.*;

public class Lab11_Fetch_HTTP_Header_Fields {

    public static void main(String[] args) throws Exception {

        @Deprecated
        URL url = new URL("https://www.example.com");
        URLConnection urlConnection = url.openConnection();

        urlConnection.connect();

        Map<String, List<String>> header = urlConnection.getHeaderFields();

        System.out.println("HTTP Header Fields:");

        for (Map.Entry<String, List<String>> mp1 : header.entrySet()) {

            System.out.println(mp1.getKey() + " : " + mp1.getValue().toString());
        }
    }
}
