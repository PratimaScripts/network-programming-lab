//Write a Simple UDP Java Program to Send Data from Client to Server

package Lab18_UDP_Send_Data_Client_To_Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Server {
    public static void main(String[] args) {

        try {
            // Create a DatagramSocket on port 5000
            DatagramSocket serverSocket = new DatagramSocket(5000);

            byte[] receiveBuffer = new byte[1024];

            // Create a DatagramPacket to receive data
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer,
                    receiveBuffer.length
            );

            System.out.println("Server is waiting for a packet...");

            // Receive data from the client
            serverSocket.receive(receivePacket);

            // Convert received bytes into a string
            String receivedMessage = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength()
            );

            System.out.println("Received: " + receivedMessage);

            // Close socket
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
