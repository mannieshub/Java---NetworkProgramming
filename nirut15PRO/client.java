import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try {
            String command = args[0].toUpperCase();
            if (!command.equals("UPLOAD") && !command.equals("SUM")) {
                System.out.println("FUCK Command");
                System.exit(1);
            }

            if (args.length == 1) {
                Socket s = new Socket("127.0.0.1", 5678);
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                // upload case
                if (command.equals("UPLOAD")) {
                    
                    pw.println(command); // send UPLOAD to Server
                    pw.flush();
                    
                    try {
                        System.out.println("readfile. . .");
                        File f = new File("man.txt");
                        String msg;
                        BufferedReader readfile = new BufferedReader(new InputStreamReader(new FileInputStream(f))); // read
                                                                                                                     // man.txt

                        while ((msg = readfile.readLine()) != null) {

                            if(msg=="END"){
                                break;
                            }
                            
                            try {
                                int convertStr = Integer.parseInt(msg);
                                pw.println(convertStr);
                                pw.flush();
                            } catch (Exception e) {
                                System.out.println("msg is not a number");
                            }
                        }
                        pw.close();
                        readfile.close();

                    } catch (Exception e) {
                    }
                    br.close();
                    pw.close();
                    s.close();
                }

                if (command.equals("SUM")) {
                    pw.println(command); // send UPLOAD to Server
                    pw.flush();
                    String msg = br.readLine();
                    System.out.println(msg);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
