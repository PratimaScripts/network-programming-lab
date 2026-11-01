package Lab19_ChatApp_Using_NIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Chat_Server {
    public static void main(String[] args) {

        System.out.println("Chat Server is started...");

        try (ServerSocketChannel serverSocketChannel =
                     ServerSocketChannel.open()) {

            // Bind server to port 5000
            serverSocketChannel.bind(new InetSocketAddress(5001));

            System.out.println("Waiting for client...");

            // Accept client connection
            try (SocketChannel socketChannel =
                         serverSocketChannel.accept()) {

                System.out.println("Client connected!");

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

                // Thread to receive messages from client
                Thread receiveThread = new Thread(() -> {
                    try {
                        String message;
                        while ((message = reader.readLine()) != null) {
                            System.out.println("Client: " + message);
                        }
                        System.out.println("Client disconnected.");
                    } catch (IOException e) {
                        System.out.println("Connection closed.");
                    }
                });

                receiveThread.start();

                // Send messages to client
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
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
