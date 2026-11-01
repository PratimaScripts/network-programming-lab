// Write a Java program to write data to a server using socket.
package Lab16_Write_Data_To_Server_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Receive_Data {
    public static void main(String[] args) throws IOException {

        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            System.out.println("Server is waiting for client...");

            // Accept incoming connections
            try (Socket socket = serverSocket.accept()) {

                System.out.println("Client connected.");

                // Create a BufferedReader to read data from the client
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                // Create a PrintWriter to send data to the client
                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream(), true
                );

                // Read data from the client
                String message = reader.readLine();

                System.out.println(
                        "Received message from client: " + message
                );

                // Send response to the client
                writer.println(
                        "Hello, client! I received your message."
                );
            }
        }
    }
}
