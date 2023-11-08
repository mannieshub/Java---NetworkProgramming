public class Grade {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter your score");
            System.exit(1);
        }
        try {
            int num = Integer.parseInt(args[0]);
            if (num >= 0 && num <= 100) {
                if (num >= 0 && num < 50) {
                    System.out.println("F");
                } else if (num >= 50 && num < 60) {
                    System.out.println("D");
                } else if (num >= 60 && num < 70) {
                    System.out.println("C");
                } else if (num >= 70 && num < 80) {
                    System.out.println("B");
                } else {
                    System.out.println("A");
                }
            } else {
                System.out.println("Please enter number 0-100");
                System.exit(1);
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter integer value");
        }

    }
}