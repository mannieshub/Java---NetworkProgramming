
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    Socket s = null;
    volatile static HashMap<String, String> map = new HashMap<String, String>();

    public Server(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            String command = br.readLine(); //อ่านค่าที่ส่งมาจากทาง client

            if (command.equals("add")) {
                String id = br.readLine();
                String name = br.readLine();
                System.out.println(name + " " + id);
                this.map.put(id, name);
                pw.println("OK");
                pw.flush();
            } else if (command.equals("search")) {
                String id = br.readLine();
                if (map.get(id) != null) {
                    pw.println(map.get(id));
                    pw.flush();
                } else {
                    pw.println("N/A");
                    pw.flush();
                }
            }

            pw.flush();
            pw.close();
            br.close();
            s.close();
        } catch (Exception e) {
            // TODO: handle exception

        }

    }

    public static void main(String[] args) {
        ServerSocket serv = null;
        ExecutorService es = Executors.newFixedThreadPool(15);
        try {
            serv = new ServerSocket(23410);
        } catch (Exception e) {
            System.exit(1);
        }
        while (true) {
            try {
                Socket s = serv.accept();
                Server st = new Server(s);
                es.execute(st);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}