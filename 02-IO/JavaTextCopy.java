import java.io.*;

public class JavaTextCopy {
    public static void main(String[] args) {
        try {

            // variable
            String s_file = args[0];
            String d_file = args[1];
            File s = new File(s_file);
            File d = new File(d_file);
            byte[] b = new byte[16];
            int n;

            // condition
            if (args.length != 2 || !s.exists()) {
                System.out.println("Usage:java JavaTextCopy<source file><destination file>");
            }

            // BufferedReader
            String msg = "";
            FileInputStream fin = new FileInputStream(s);
            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(ir);

            // add msg by concat
            while ((n = fin.read(b)) > 0) {
                System.out.println(msg);
                msg += new String(b, 0, n);
            }
            fin.close();

            // PrintWriter
            FileOutputStream fout = new FileOutputStream(d);
            PrintWriter pout = new PrintWriter(fout);
            pout.print(msg); // write msg to destination file
            pout.flush();
            pout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
