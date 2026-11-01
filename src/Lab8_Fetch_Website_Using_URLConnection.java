// Write a Java program to fetch website content using the URLConnection class.
// Write a program to download a web page using URL Connection class.

import java.io.*;
import java.net.*;

public class Lab8_Fetch_Website_Using_URLConnection {

    public static void main(String[] args) {

        String urlString = "https://example.com";
        String page = "index.html";

        try {
            // Creating a URL Object
            @Deprecated
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection uc = url.openConnection();

            uc.connect();

            InputStream inputStream = uc.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream));

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(page));

            // Read the content line by line
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();

//                System.out.println(line);
            }

            bufferedReader.close();
            bufferedWriter.close();
            inputStream.close();
            System.out.println("Page Downloaded Successfully " + page);

        } catch (IOException e) {
            System.out.print("Error" + e.getMessage());
        }
    }
}
