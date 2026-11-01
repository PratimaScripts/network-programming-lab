// Write a Java program to manage HTTP cookies using the CookieStore and HttpCookie classes.
// Also add, retrieve, and remove cookies from a CookieStore.

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class Lab10_HTTP_Cookies_Using_CookieStore {
    private static final String URL_STRING = "https://www.example.com";

    public static void main(String[] args) throws Exception {

        // Create a CookieManager with a default CookieStore
        CookieManager cookieManager = new CookieManager();

        CookieStore cookieStore = cookieManager.getCookieStore();

        // Create cookies
        HttpCookie cookieA = new HttpCookie("First", "1");

        HttpCookie cookieB = new HttpCookie("Second", "2");

        cookieA.setMaxAge(3600);

        cookieA.setSecure(false);

        // Create a URI for the cookies (e.g., a specific website or domain)
        URI uri = URI.create(URL_STRING);

        // Add cookies to CookieStore
        cookieStore.add(uri, cookieA);

        cookieStore.add(null, cookieB);

        System.out.println("Cookies successfully added.\n");

        // Retrieve cookies associated with URI
        List<HttpCookie> cookiesWithURI = cookieStore.get(uri);

        System.out.println("Cookies associated with URI: " + cookiesWithURI + "\n");

        // Retrieve all cookies
        List<HttpCookie> cookieList = cookieStore.getCookies();

        System.out.println("All Cookies in CookieStore: " + cookieList + "\n");

        // Retrieve all URIs
        List<URI> uriList = cookieStore.getURIs();

        System.out.println("URIs in CookieStore: " + uriList + "\n");

        // Remove a specific cookie
        System.out.println("Removal of Cookie: " + cookieStore.remove(uri, cookieA));

        // Display remaining cookies
        System.out.println("Remaining Cookies: " + cookieStore.getCookies() + "\n");

        // Remove all cookies
        System.out.println("Removal of All Cookies: " + cookieStore.removeAll());

        // Display empty CookieStore
        System.out.println("Empty CookieStore: " + cookieStore.getCookies());
    }
}
