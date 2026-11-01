// Write a Java program to find Base URL, Relative URL, and Resolved URL from the given URL.
// https://meganationalcollege.edu.np/wp-content/uploads/2026/11/Network_Programming-Syllabus.zip./.

import java.net.*;

public class Lab5_BaseURL_RelativeURL_ResolvedURL {

    public static void main(String[] args) throws MalformedURLException {

        String baseUrl = "https://meganationalcollege.edu.np/wp-content/uploads/2026/11/";

        String relativeUrl = "Networking_Programming-Syallabus.zip";

        @Deprecated
        URL baseURL = new URL(baseUrl);

        @Deprecated
        URL resolvedRelativeURL = new URL(baseURL, relativeUrl);

        System.out.println("Base URL: " + baseUrl);

        System.out.println("Relative URL: " + relativeUrl);

        System.out.println("Resolved URL: " + resolvedRelativeURL);

    }
}

