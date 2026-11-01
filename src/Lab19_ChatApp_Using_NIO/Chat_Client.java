package Lab19_ChatApp_Using_NIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Chat_Client {
    public static void main(String[] args) {

        try (SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress("127.0.0.1", 5001))) {

            System.out.println("Connected to chat server!");

            BufferedReader reader = new BufferedReader(
                    Channels.newReader(
                            socketChannel,
                            StandardCharsets.UTF_8.newDecoder(),
                            -1
                    )
            );

            BufferedWriter writer = new BufferedWriter(
                    Channels.newWriter(
                            socketChannel,
                            StandardCharsets.UTF_8.newEncoder(),
                            -1
                    )
            );

            // Thread to receive messages from server
            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                    System.out.println("Server disconnected.");
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });

            receiveThread.start();

            // Send messages to server
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(message);
                writer.newLine();
                writer.flush();
            }

            socketChannel.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
