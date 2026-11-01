// Write a java program to retrieving Specific Header Fields from URL using URL connection Class.

import java.net.*;
import java.util.*;

public class Lab12_Retrieve_Specific_Header_Fields {
    public static void main(String[] args) throws Exception {

        @Deprecated
        URL u = new URL("https://iost.tu.edu.np/pages/contact-us-334");
        URLConnection uc = u.openConnection();

        System.out.println("Content-type: " + uc.getContentType());
        System.out.println("Content-encoding: " + uc.getContentEncoding());
        System.out.println("Date: " + new Date(uc.getDate()));
        System.out.println("Last modified: " + new Date(uc.getLastModified()));
        System.out.println("Expiration date: " + new Date(uc.getExpiration()));
        System.out.println("Content-length: " + uc.getContentLength());

    }
}
