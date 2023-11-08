public class JavaThread extends Thread {
    int num;

    public JavaThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println(num + " Hello World");

    }

    public static void main(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);

            for (int i = 1; i <= number; i++) { // จาก loop นี้จะทำการสร้าง object ของ class ตามจำนวน parameter
                JavaThread t = new JavaThread(i);
                t.start();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
