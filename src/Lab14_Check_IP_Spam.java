/* Write a program to check IP Address weather spam or not. */

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

// Add program arguments in the run configuration. e.g. 8.8.8.8 1.1.1.1

public class Lab14_Check_IP_Spam {
    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {

        if (args.length == 0) {
            System.out.println("Please provide an IP address.");
            System.out.println("Example: java SpamCheck 8.8.8.8");
            return;
        }

        for (String arg : args) {

            if (isSpammer(arg)) {
                System.out.println(arg + " is a known spammer.");
            } else {
                System.out.println(arg + " appears legitimate.");
            }
        }
    }

    public static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);

            // This example handles IPv4 addresses only.
            if (!(address instanceof Inet4Address)) {
                return false;
            }

            byte[] quad = address.getAddress();

            String query = BLACKHOLE;

            for (byte octet : quad) {
                int unsignedByte = octet < 0
                        ? octet + 256
                        : octet;

                query = unsignedByte + "." + query;
            }

            InetAddress.getByName(query);

            // DNSBL lookup succeeded.
            return true;

        } catch (UnknownHostException e) {

            // The DNSBL lookup did not return an address.
            return false;
        }
    }
}
