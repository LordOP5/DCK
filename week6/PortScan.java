import  java.net.*;
import java.io.*;

public class PortScan {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java PortScan <hostname/IP>");
			return;
        }

        String input = args[0];

        for (int i = 70; i <= 100; i++){
            try {
                Socket socket = new Socket(input,i);
                socket.close();
                System.out.println("port " + i + " : open");
            } catch (Exception e) {}
        }
    }
}