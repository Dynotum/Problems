import java.io.*;

/**
 * If you need to read a text, use character input streams.
 * Otherwise, for example, while reading audio, video, zip and etc., use byte input streams.
 */

public class Main {

    public static void main(String[] args) {
//        readFile2();

        inputStreamBytes();
    }

    // Read a File Inputs Streams
    private static void readFile() {
        try {
            Reader reader = new FileReader("Streams" + File.separator + "file.txt");
            char first = (char) reader.read();
            char second = (char) reader.read();

            System.out.println(first);
            System.out.println(second);

            char[] array = new char[100];
            int number = reader.read(array);

            System.out.println(number);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readFile2() {
        try (var reader = new FileReader("Streams" + File.separator + "file.txt")) {

            int asciiIntValue = reader.read();

            while (asciiIntValue != -1) {
                System.out.println(asciiIntValue);
                char charValue = (char) asciiIntValue;
                System.out.println(charValue);
                asciiIntValue = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void inputStreamBytes() {
        try (FileInputStream fis = new FileInputStream("Streams" + File.separator + "file.txt")) {
            byte[] bytes = new byte[10];

            System.out.println(fis.read(bytes));
            int numBytes = fis.read();


            while (numBytes != -1) {
                System.out.println(numBytes);
                System.out.println((char) numBytes);
                numBytes = fis.read();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void problem() {
        /*
        Sample Input 1:
        one two three

        Sample Output 1:
        3

        Sample Input 2:
        between   us  several   space characters

        Sample Output 2:
        5
        */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int currentChar = reader.read();

            int counter = 0;
            while (currentChar != -1) {
                if (currentChar == 32) {
                    counter++;
                }

            }
            System.out.println(counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}