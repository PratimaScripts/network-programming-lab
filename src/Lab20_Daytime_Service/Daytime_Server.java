package Lab20_Daytime_Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Daytime_Server {
    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Daytime Server started...");
        System.out.println("Waiting for client connection...");

        // Accept client connection
        Socket clientSocket = serverSocket.accept();

        System.out.println("Connected to Client");

        // Get current date and time
        String currentDateTime = new Date().toString();

        // Send date and time to client
        PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true
        );

        out.println(currentDateTime);

        System.out.println("Date and time sent to client.");

        // Close connections
        clientSocket.close();
        serverSocket.close();
    }
}
