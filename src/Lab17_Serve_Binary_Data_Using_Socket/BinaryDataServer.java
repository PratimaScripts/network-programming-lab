// Write a Java program to serve binary data using socket.
package Lab17_Serve_Binary_Data_Using_Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BinaryDataServer {
    public static void main(String[] args) {

        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(5001)) {

            System.out.println("Server is listening on port 5001...");

            // Wait for a client to connect
            try (Socket clientSocket = serverSocket.accept()) {

                System.out.println("Client connected!");

                // Prepare the output stream to send binary data
                DataOutputStream dataOut = new DataOutputStream(
                        clientSocket.getOutputStream()
                );

                // Example: Send a binary data sequence
                byte[] binaryData = {0x01, 0x02, 0x03, 0x04, 0x05};

                // Send binary data to the client
                dataOut.write(binaryData);
                dataOut.flush();

                System.out.println("Binary data sent to client.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
