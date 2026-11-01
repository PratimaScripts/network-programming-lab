// Write a Java program to split different components of a URL from the given URL.
// https://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section2

import java.net.MalformedURLException;
import java.net.URL;

public class Lab6_Split_URL_Components {

    public static void main(String[] args) throws MalformedURLException {

        URL url1 = new URL("https://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section2");

        System.out.println(url1.toString());

        System.out.println();

        System.out.println("Different components of the URL:");

        System.out.println("Protocol: " + url1.getProtocol());

        System.out.println("Hostname: " + url1.getHost());

        System.out.println("Port: " + url1.getPort());

        System.out.println("Default Port: " + url1.getDefaultPort());

        // Retrieving the query part of URL
        System.out.println("Query: " + url1.getQuery());

        // Retrieving the path of URL
        System.out.println("Path: " + url1.getPath());

        // Retrieving the file name
        System.out.println("File: " + url1.getFile());

        // Retrieving the reference
        System.out.println("Reference: " + url1.getRef());

    }
}
