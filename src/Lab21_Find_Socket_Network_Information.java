// Write a Java Program to Find Web Address, IP Address, Server Port, Local Port, and Local IP Address Using Socket with host address www.oreilly.com

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Lab21_Find_Socket_Network_Information {
    public static void main(String[] args) {

        String host = "www.oreilly.com";

        try {
            // Create a socket connection to the web server
            Socket theSocket = new Socket(host, 80);

            // Display socket information
            System.out.println("Web Address: " + host);

            System.out.println("IP Address: " + theSocket.getInetAddress().getHostAddress());

            System.out.println("Server Port: " + theSocket.getPort());

            System.out.println("Local Port: " + theSocket.getLocalPort());

            System.out.println("Local IP Address: " + theSocket.getLocalAddress().getHostAddress());

            // Close socket connection
            theSocket.close();

        } catch (UnknownHostException ex) {
            System.err.println("Cannot find host: " + host);

        } catch (SocketException ex) {
            System.err.println("Could not connect to " + host);

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
