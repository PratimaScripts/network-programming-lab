// Write a Java Program to Scan Local TCP Ports from Port 1024 Upwards

import java.io.IOException;
import java.net.ServerSocket;

public class Lab22_Scan_Local_TCP_Ports {
    public static void main(String[] args) throws Exception {

        int startingPort = 1024;
        int endingPort = 65535;

        System.out.println("Scanning local TCP ports...");

        for (int p = startingPort; p <= endingPort; p++) {

            if (isPortAvailable(p)) {
                System.out.print(p + " ");
            }
        }

        System.out.println("\nPort scanning completed.");
    }

    // Method to check whether a local TCP port is available
    private static boolean isPortAvailable(int port) {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.close();

            return true;

        } catch (IOException e) {
            return false;
        }
    }
}
