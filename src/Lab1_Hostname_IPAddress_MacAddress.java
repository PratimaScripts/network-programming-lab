// Write a Java program to retrieve Host Name, IP Address, and MAC Address of the Local Machine.

import java.net.InetAddress;
import java.net.NetworkInterface;

public class Lab1_Hostname_IPAddress_MacAddress {
    public static void main(String[] args) throws Exception{
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        String ipAddress = localHost.getHostAddress();
        NetworkInterface network = NetworkInterface.getByInetAddress(localHost);
        byte[] mac = network.getHardwareAddress();

        // Print the details
        System.out.println("Hostname: " + hostName);
        System.out.println("IP Address: " + ipAddress);
        System.out.print("MacAddress: ");
        if (mac != null) {
            for (int i = 0; i < mac.length; i++) {
                System.out.printf("%02X", mac[i]);

                if (i < mac.length - 1) {
                    System.out.print("-");
                }
            }
        } else {
            System.out.println("MAC Address not available.");
        }
    }
}