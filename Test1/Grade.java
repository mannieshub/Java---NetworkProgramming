public class Grade {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Input must have 1 number");
            System.exit(1);
        }
        if (args.length == 0) {
            System.out.println("Please Enter Your Score");
            System.exit(1);
        }

        int score = Integer.parseInt(args[0]);

        if (score < 0 || score > 100) {
            System.out.println("Please enter number 0-100");
        }

        try {
            if (score >= 0 && score < 50) {
                System.out.println("F");
            }
            if (score >= 50 && score < 60) {
                System.out.println("D");
            }
            if (score >= 60 && score < 70) {
                System.out.println("C");
            }
            if (score >= 70 && score < 80) {
                System.out.println("B");
            }
            if (score >= 80 && score <= 100) {
                System.out.println("A");
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println("Please enter integer number");
        }

    }
}
