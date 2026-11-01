// Write a Java program to list all the network interfaces on the local machine.

import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class Lab4_List_Network_Interfaces {

    public static void main(String[] args) throws IOException {

        Enumeration<NetworkInterface> interfaces =
                NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {

            NetworkInterface ni = (NetworkInterface) interfaces.nextElement();

            System.out.println(ni);
            System.out.println("Interface Name: " + ni.getName());
            System.out.println("Display Name: " + ni.getDisplayName());

            System.out.println("----------------------------");
        }
    }
}
