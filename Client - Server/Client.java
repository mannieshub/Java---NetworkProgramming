import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1", 23410);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            
            if (args[0].toLowerCase().equals("search")) {
                if (args.length < 2) {
                    throw new Exception();
                }
                pw.println(args[0]);
                pw.println(args[1]);
            } else if (args[0].toLowerCase().equals("add")) {
                pw.println(args[0]);
                pw.println(args[1]);
                pw.println(args[2]);
            } else {
                throw new Exception();
            }
            pw.flush();
            String msg = br.readLine();
            System.out.println(msg);
            br.close();
            pw.close();
            s.close();
        } catch (Exception e) {
            // TODO: handle
            System.out.println("Command not found");
        }
    }
}