// Write a Java program to read data from a server using socket.
package Lab15_Read_Data_From_Server_Socket;

import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main(String[] args) throws IOException {

        // Create a socket object
        Socket clientSocket = new Socket("localhost", 8080); // replace with server ip and port

        // Create a BufferedReader to read data from the server
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        );

        // Read data from the server
        String serverResponse;
        while ((serverResponse = in.readLine()) != null) {
            System.out.println("Server says: " + serverResponse);
        }

        // Close the socket
        clientSocket.close();
    }
}