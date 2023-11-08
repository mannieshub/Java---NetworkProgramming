public class JavaSyncTest implements Runnable {
    // สร้าง 3 Thread
    // แต่ละ Thread จะมีการ loop เพิ่มค่าในตัวแปร balance

    // volatile ทำให้หลาย Thread สามารถแก้ไข variable เดียวกันได้
    // static แชร์ variable หรือ method ของ class ที่กำหนด => ทำให้ไม่ต้องประกาศซ้ำ

    static volatile int balance = 0;
    static Object o = new Object();

    // Thread working
    public void run() {
        for (int i = 0; i < 100000; i++) {
            synchronized (o) {
                balance++;
            }
        }

    }

    public int getBalance() {
        return balance; // ตัวแปร
    }

    public static void main(String[] args) {

        // create Object j1,j2,j3
        JavaSyncTest j1 = new JavaSyncTest();
        JavaSyncTest j2 = new JavaSyncTest();
        JavaSyncTest j3 = new JavaSyncTest();

        // create 3 Threads
        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j2);
        Thread t3 = new Thread(j3);

        // Thread start
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {

        }

        System.out.println(balance);
    }
}
