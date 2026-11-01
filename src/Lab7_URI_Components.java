// Write a Java program to get different parts of a URI from the given URI.
// http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc

import java.net.*;

public class Lab7_URI_Components {

    public static void main(String[] args) throws Exception {

        String str = "http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc";

        URI uri = URI.create(str);

        System.out.println("URI: " + uri.normalize().toString());

        System.out.println();

        System.out.println("Different Components of URI:");

        System.out.println("Scheme: " + uri.getScheme());

        System.out.println("Scheme Specific Part: " + uri.getSchemeSpecificPart());

        System.out.println("Raw User Info: " + uri.getRawUserInfo());

        System.out.println("User Info: " + uri.getUserInfo());

        System.out.println("Authority: " + uri.getAuthority());

        System.out.println("Host: " + uri.getHost());

        System.out.println("Path: " + uri.getPath());

        System.out.println("Port: " + uri.getPort());

        System.out.println("Query: " + uri.getQuery());

        System.out.println("Fragment: " + uri.getFragment());

    }
}

