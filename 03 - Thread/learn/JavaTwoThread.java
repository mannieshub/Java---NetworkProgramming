public class JavaTwoThread implements Runnable {

    int start;
    int end;
    int result;
    long sleeptime;

    public JavaTwoThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // override method run
    public void run() {
        for (int i = 0; i <= end; i++) {
            result += i;
        }
        try {
            System.out.println("summation is " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getResult() {
        return result;
    }

    public static void main(String[] args) {

        int sum = 0;
        // create Obj of class JavaTwoThread
        JavaTwoThread sum1 = new JavaTwoThread(1, 5000);
        JavaTwoThread sum2 = new JavaTwoThread(5001, 10000);

        // create Obj Thread of class JavaTwoThread
        Thread t1 = new Thread(sum1);
        Thread t2 = new Thread(sum2);

        try {
            // start Thread
            t1.start();
            // sleep Thread
            Thread.sleep(5000);
            // start Thread
            t2.start();
            // sleep Thread
            Thread.sleep(10000);

            // summation
            sum = sum1.getResult() + sum2.getResult();
        } catch (Exception e) {

        }
        System.out.println(sum);

    }
}