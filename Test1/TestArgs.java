public class TestArgs {
    public static void main(String[] args) {
        // check 2 number or not else Exit
        if (args.length != 2) {
            System.out.println("Usage : java TestArgs <number 1><number 2>");
            System.exit(1);
        }

        // convert String args[index] to float
        float num1 = Float.parseFloat(args[0]);
        float num2 = Float.parseFloat(args[1]);
        // variable
        float count = num1 * num2;

        try {
            // display num1 x num2
            System.out.println(count);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}