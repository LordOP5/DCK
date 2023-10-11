import java.io.*;
import java.net.*;
import java.util.*;

public class DateTimeClient {
    public static void main(String[] args) {
        try {
            byte[] sendBuffer = new byte[8000];
            byte[] recvBuffer = new byte[8000];
            InetAddress ia = InetAddress.getByName("127.0.0.1");

            DatagramSocket socket = new DatagramSocket();

            DatagramPacket seadDP = new DatagramPacket(sendBuffer, sendBuffer.length, ia, 9876);
            socket.send(seadDP);

            DatagramPacket recvDP = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(recvDP);
            String s = new String(recvDP.getData(), 0, recvDP.getLength());
            System.out.println("Server Time --> " + s);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
