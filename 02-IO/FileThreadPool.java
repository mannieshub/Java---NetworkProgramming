import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class FileThreadPool implements Runnable {
    int num;

    public FileThreadPool(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println(num + " -> " + ((int) Math.pow(num, 2)));

    }

    public static void main(String[] args) {
        // Buffered Reader
        String name = args[0];
        try {
            String msg;
            File f = new File(name);

            FileInputStream fin = new FileInputStream(f);
            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(ir);

            ExecutorService es = Executors.newFixedThreadPool(3); // create Thread pool have 3 Thread

            while ((msg = br.readLine()) != null) {
                // msg = br.readLine() => readLine method is read data every line
                int len = Integer.parseInt(msg); // convert msg from string to integer
                FileThreadPool ftp = new FileThreadPool(len); // create Obj of class FileThreadPool
                es.execute(ftp); // ftp executing
            }
            fin.close(); // stop
            es.shutdown(); // stop Thread pool working

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
