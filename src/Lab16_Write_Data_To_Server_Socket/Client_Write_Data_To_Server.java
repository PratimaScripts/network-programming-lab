// Write a Java program to write data to a server using socket.
package Lab16_Write_Data_To_Server_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_Write_Data_To_Server {
    public static void main(String[] args) throws IOException {

        // Create a socket object
        try (Socket clientSocket = new Socket("localhost", 8080)) {

            // Create a PrintWriter to send data to the server
            PrintWriter writer = new PrintWriter(
                    clientSocket.getOutputStream(), true
            );

            // Create a BufferedReader to read user input
            BufferedReader userInputReader = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            // Write data to the server
            System.out.print("Enter a message to send to the server: ");
            String message = userInputReader.readLine();

            writer.println(message);

            // Read response from the server
            BufferedReader serverResponseReader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            String response = serverResponseReader.readLine();

            System.out.println("Server response: " + response);
        }
    }
}
