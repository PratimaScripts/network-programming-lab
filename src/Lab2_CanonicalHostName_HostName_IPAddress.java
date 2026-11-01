// Write a java program to find canonicalHostName, HostName, IpAddress of www.google.com.np.

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab2_CanonicalHostName_HostName_IPAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.google.com.np");
        System.out.println("Canonical Host Name: " + address.getCanonicalHostName());
        System.out.println("Host Name: " + address.getHostName());
        System.out.println("IP Address: " + address.getHostAddress());
        byte[] arr= address.getAddress();
        for(byte b : arr){
            System.out.println(b);
        }
    }
}
