import java.io.*;
import java.net.*;
import java.util.*;

public class DateTimeServer {
    public static void main(String[] args) {

        boolean Connection = true;

        try {
            DatagramSocket socket = new DatagramSocket(9876);

            while (true) {
                Date now = new Date();
                String time = now.toString();
                byte[] recvBuffer = new byte[8000];

                DatagramPacket dp = new DatagramPacket(recvBuffer, recvBuffer.length);
                socket.receive(dp);

                if (Connection) {
                    System.out.println("Current Time = " + now.toString());
                    Connection = false;
                }

                byte[] sendTime = time.getBytes();

                DatagramPacket dp2 = new DatagramPacket(sendTime, sendTime.length, dp.getAddress(), dp.getPort());
                socket.send(dp2);
                System.out.println("Client Connected..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
