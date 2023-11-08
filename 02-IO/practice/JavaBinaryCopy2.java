package practice;

import java.io.*;

public class JavaBinaryCopy2 {
    public static void main(String[] args) {
        // รับ parameter 2 ตัว คือ original_file กับ newCopy_file
        // ถ้า parameter != 2 exit => "JavaBinaryCopy <source file><destination file>"
        if (args.length != 2) {
            System.out.println("JavaBinaryCopy <source file><destination file>");
            System.exit(1);
        }

        try {

            int n;
            byte[] b = new byte[16];
            String msg = "";

            String s_file = args[0];
            File source_file = new File(s_file);

            String d_file = args[1];
            File destination_file = new File(d_file);

            FileInputStream fin = new FileInputStream(source_file);
            FileOutputStream fout = new FileOutputStream(destination_file);
            while ((n = fin.read(b)) > 0) {
                msg += new String(b, 0, n);
            }
            b = msg.getBytes();
            fout.write(b);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // FileInputStream และ FileOutputStream
    }

}
