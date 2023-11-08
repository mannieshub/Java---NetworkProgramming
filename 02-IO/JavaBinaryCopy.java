import java.io.*;

public class JavaBinaryCopy {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Usage:java JavaBinaryCopy<source file><destinationfile>");
                System.exit(1);
            }

            // variable
            int n;
            byte[] b = new byte[16];// create blank object to keep content
            String data = "";

            // read source_file
            String source_file = args[0];
            File f = new File(source_file);
            FileInputStream fin = new FileInputStream(f);

            while ((n = fin.read(b)) > 0) {
                data += new String(b, 0, n);
                System.out.println(data);
            }
            fin.close();

            // write destination
            String destination_file = args[1];
            File d = new File(destination_file);
            FileOutputStream fout = new FileOutputStream(d);
            fout.write(data.getBytes());
            fout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}