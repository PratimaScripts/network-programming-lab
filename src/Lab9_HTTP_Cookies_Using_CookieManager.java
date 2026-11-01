// Write a program to handle HTTP cookies in Java using the CookieManager and HttpCookie classes.
// Also retrieve and display cookie information from a specified URL.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

public class Lab9_HTTP_Cookies_Using_CookieManager {

    private final static String URL_STRING = "https://acsc.nepalarmy.mil.np";

    public static void main(String[] args) {

        CookieManager cookieManager = new CookieManager();

        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        // Register CookieManager as the default cookie handler
        CookieHandler.setDefault(cookieManager);

        try {
            URL obj = new URL(URL_STRING);

            HttpURLConnection con =
                    (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Add cookie manager to the connection
            con.setRequestProperty("Cookie",
                    cookieManager.getCookieStore().getCookies().toString());

            int responseCode = con.getResponseCode();

            System.out.println("Response Code: " + responseCode);

            // Retrieve cookies from the cookie store
            List<HttpCookie> cookies =
                    cookieManager.getCookieStore().getCookies();

            System.out.println("\nCookie Information:");

            if (cookies.isEmpty()) {
                System.out.println("No cookies received from the website.");
            }

            for (HttpCookie cookie : cookies) {

                System.out.println("Cookie Name: " + cookie.getName());

                System.out.println("Cookie Value: " + cookie.getValue());

                System.out.println("Cookie Domain: " + cookie.getDomain());

                System.out.println("Cookie Path: " + cookie.getPath());

                System.out.println("Cookie Max Age: " + cookie.getMaxAge());

                System.out.println("Cookie Secure: " + cookie.getSecure());

                System.out.println("Cookie HttpOnly: " + cookie.isHttpOnly());

                System.out.println("Cookie Version: " + cookie.getVersion());

                System.out.println("------------------------");
            }

            // Read website response
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String inputLine;

            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine).append("\n");
            }

            in.close();

            System.out.println("\nWebsite Content:");

            System.out.println(response.toString());

            con.disconnect();

        } catch (MalformedURLException e) {

            System.out.println("Malformed URL: " + e.getMessage());

        } catch (IOException e) {

            System.out.println("IO Exception: " + e.getMessage());

        }
    }
}
