import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9000);
            while(true){
                byte[] recvBuffer = new byte[8000];

                DatagramPacket dp = new DatagramPacket(recvBuffer, recvBuffer.length);
                socket.receive(dp);
                DatagramPacket dp2 = new DatagramPacket(dp.getData(), dp.getLength(),dp.getAddress(),dp.getPort());
                socket.send(dp2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
