// Write a Simple UDP Java Program to Send Data from Client to Server

package Lab18_UDP_Send_Data_Client_To_Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Client {
    public static void main(String[] args) throws Exception {

        // Create a DatagramSocket
        DatagramSocket clientSocket = new DatagramSocket();

        // Message to send
        String message = "Hello, UDP Server!";

        // Convert message into bytes
        byte[] sendBuffer = message.getBytes();

        // Get server address
        InetAddress serverAddress = InetAddress.getByName("localhost");

        // Create a DatagramPacket
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                serverAddress,
                5000
        );

        // Send data to the server
        clientSocket.send(sendPacket);

        System.out.println("Message sent to server: " + message);

        // Close socket
        clientSocket.close();
    }
}
