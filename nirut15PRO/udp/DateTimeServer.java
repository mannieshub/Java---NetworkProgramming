import java.net.*;
import java.util.*;

public class DateTimeServer {
    public static void main(String[] args) {
        try {
            byte[] sendBuffer;
            Date now = new Date();
            System.out.println("Current Time = " + now.toString());
            DatagramSocket socket = new DatagramSocket (9876); 
            
            while(true) {
                byte[] recvBuffer = new byte[8000];
                DatagramPacket dp = new DatagramPacket(recvBuffer, recvBuffer.length);
                socket.receive(dp);
                System.out.println("Client connected ...");
                Date nownow = new Date();
                String msg = nownow.toString();
                sendBuffer = msg.getBytes(); 
                DatagramPacket dp2 = new DatagramPacket(sendBuffer,
                                                        sendBuffer.length,
                                                        dp.getAddress(),
                                                        dp.getPort());
                socket.send(dp2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}