// Write a Java Program to Perform URL Encoding and Decoding.

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Lab13_URL_Encoding_Decoding {
    public static void main(String[] args) {

        String originalString = "Hello World! 50% off on all items.";
        String charset = "UTF-8";

        try {
            // URL Encoding
            String encodedString = URLEncoder.encode(originalString, charset);
            System.out.println("Encoded String: " + encodedString);

            // URL Decoding
            String decodedString = URLDecoder.decode(encodedString, charset);
            System.out.println("Decoded String: " + decodedString);

        } catch (UnsupportedEncodingException e) {
            System.err.println("Encoding not supported: " + e.getMessage());
        }
    }
}
