import  java.net.*;
import java.io.*;

public class JavaIP {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java JavaIP <hostname/IP>");
			return;
        }

        String input = args[0];

        try {
            InetAddress ad = InetAddress.getByName(input);
            System.out.println("Host = " + ad.getHostName());
            System.out.println("IP = " + ad.getHostAddress());
        } catch (Exception e) {
            System.out.println("Error: unknown host or IP address");
        }
    }
}