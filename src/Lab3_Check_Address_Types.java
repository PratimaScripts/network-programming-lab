// Write a Java program to check Loopback Address, Private Address, Multicast Address, and Any Local Address.

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab3_Check_Address_Types {
    public static void main(String[] args) throws Exception {

        String[] ipAddresses = {
                "127.0.0.1",
                "192.168.1.1",
                "224.0.0.1",
                "0.0.0.0",
                "8.8.8.8"
        };

        for (String ipAddress : ipAddresses) {
            try {
                InetAddress address = InetAddress.getByName(ipAddress);
                System.out.println("Checking IP address: " + ipAddress);
                checkAddressType(address);
                System.out.println();
            } catch (UnknownHostException e) {
                System.err.println("Invalid IP address: " + ipAddress);
                e.printStackTrace();
            }
        }
    }

    public static void checkAddressType(InetAddress address) {
        if (address.isLoopbackAddress()) {
            System.out.println(address + " is a loopback address.");
        }
        if (address.isSiteLocalAddress()) {
            System.out.println(address + " is a private address.");
        }
        if (address.isMulticastAddress()) {
            System.out.println(address + " is a multicast address.");
        }
        if (address.isAnyLocalAddress()) {
            System.out.println(address + " is an any local address/unspecified address.");
        }
        if (!address.isLoopbackAddress() && !address.isSiteLocalAddress() &&
                !address.isMulticastAddress() && !address.isAnyLocalAddress()) {
            System.out.println("This is a public/global address.");
        }
    }
}