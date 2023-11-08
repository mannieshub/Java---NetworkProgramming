import java.io.*;
import java.nio.Buffer;

public class JavaList {
    public static void main(String[] args) {

        try {
            String path = args[0];
            String msg = "";
            int n;
            byte[] b = new byte[16];

            if (args.length != 1) {
                System.out.println("stupid shit");
                System.exit(1);
            }
            File f = new File(path);
            File list[] = f.listFiles();

            FileInputStream fin = new FileInputStream(f);
            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(ir);

            if (f.isDirectory()) {
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isFile()) {
                        System.out.println(list[i].getName() + " is File");
                    } else {
                        System.out.println(list[i].getName() + "is Directory");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
