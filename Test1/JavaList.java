import java.io.File;

public class JavaList {
    public static void main(String[] args) {
        // check number arguments
        if (args.length != 1) {
            System.out.println("Usage : JavaList ");
            System.exit(1);
        }

        try {

            String path = args[0];
            File f = new File(path);
            File list[] = f.listFiles();

            // if file/directory not exist
            if (!f.exists()) {
                System.out.println("File not found");
            } else {
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isDirectory()) {
                        System.out.println(list[i].getName() + " is Directory");
                    } else if (list[i].isFile()) {
                        System.out.println(
                                list[i].getName() + " is File and file size is " + list[i].length() + " Byte ");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
