import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class server implements Runnable {
    Socket s = null;
    static int sum = 0;
    static String data = "";

    public server(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());

            String command = br.readLine(); // receive data from client
            String msg;

            if (command.equals("UPLOAD")) {
                while ((msg = br.readLine()) != null) {
                    data += (msg + " ");
                }
            } 
            else if (command.equals("SUM")) {
                String[] array = null;
                array = data.split(" ");
                if (data == "") {
                    pw.println("please upload data first");
                    pw.flush();
                } else {
                    for (int i = 0; i < array.length; i++) {
                        sum += Integer.parseInt(array[i]);
                    }
                }
                pw.println(sum);
                pw.flush();
                pw.close();
                br.close();
                s.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        ServerSocket servSocket = null;
        ExecutorService es = Executors.newFixedThreadPool(70);

        try {
            servSocket = new ServerSocket(5678);

        } catch (Exception e) {
            // TODO: handle exception
        }

        while (true) {
            try {
                Socket s = servSocket.accept();
                server serv = new server(s);
                es.execute(serv);

            } catch (Exception e) {
            }
        }
    }
}
