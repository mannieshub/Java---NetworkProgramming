public class JavaTwoThread implements Runnable {
    int start;
    int end;
    int result = 0;
    long sleepTime = 0;

    // รับ 2 parameter คือ start = ค่าเริ่มต้น และ end = ค่าสุดท้าย
    public JavaTwoThread(int start, int end) {

        this.start = start;// start ใน class(line 2)นี้ จะมีค่าเท่ากับ start ที่เป็น parameter
        this.end = end;// end ใน class(line 3)นี้ จะมีค่าเท่ากับ end ที่เป็น parameter

    }

    public void run() {
        for (int i = start; i <= end; i++) {
            result += i;
        }
        try {
            System.out.println("summation = " + result);
        } catch (Exception e) {
        }
    }

    public int getResult() {
        return result;
    }

    public static void main(String[] args) {
        int sum = 0;
        JavaTwoThread first = new JavaTwoThread(1, 5000);
        JavaTwoThread second = new JavaTwoThread(5001, 10000);

        Thread s1 = new Thread(first);
        Thread s2 = new Thread(second);

        try {
            s1.start();
            Thread.sleep(5000);
            s2.start();
            Thread.sleep(10000);

            // s1.join();
            // s2.join();

            // sum = first.getResult() + second.getResult();

        } catch (Exception e) {

        }

        System.out.println("Result 2 = " + sum);

    }
}