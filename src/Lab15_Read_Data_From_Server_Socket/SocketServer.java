// Write a Java program to read data from a server using socket.
package Lab15_Read_Data_From_Server_Socket;

import java.io.*;
import java.net.*;

public class SocketServer {
    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is waiting for client...");

        // Accept incoming connections
        Socket clientSocket = serverSocket.accept();

        System.out.println("Connected to Client");

        // Create a PrintWriter to send data to the client
        PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true
        );


        out.println("Hello from server");

        // Close the socket
        clientSocket.close();
        serverSocket.close();
    }
}
