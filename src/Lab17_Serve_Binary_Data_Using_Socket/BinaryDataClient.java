// Write a Java program to serve binary data using socket.
package Lab17_Serve_Binary_Data_Using_Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class BinaryDataClient {
    public static void main(String[] args) {

        // Connect to the server
        try (Socket socket = new Socket("localhost", 5001)) {

            System.out.println("Connected to server!");

            // Prepare the input stream to receive binary data
            DataInputStream dataIn = new DataInputStream(
                    socket.getInputStream()
            );

            // Read binary data from the server
            byte[] buffer = new byte[5];

            dataIn.readFully(buffer);

            System.out.println("Binary data received from server:");

            // Display binary data in hexadecimal format
            for (byte b : buffer) {
                System.out.printf("0x%02X ", b);
            }

            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
