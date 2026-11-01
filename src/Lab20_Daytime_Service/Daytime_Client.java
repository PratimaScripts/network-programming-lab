package Lab20_Daytime_Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Daytime_Client {
    public static void main(String[] args) throws IOException {

        // Connect to the server
        Socket clientSocket = new Socket("localhost", 1234);

        // Read data received from server
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        );

        // Receive current date and time
        String serverResponse = in.readLine();

        // Display server response
        System.out.println("Server says: " + serverResponse);

        // Close connection
        clientSocket.close();
    }
}
