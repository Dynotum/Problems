import org.w3c.dom.html.HTMLParagraphElement;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * If you need to read a text, use character input streams.
 * Otherwise, for example, while reading audio, video, zip and etc., use byte input streams.
 */

public class Main {

    public static void main(String[] args) {

//        int[] result = twoNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);
//        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3));
//        Arrays.stream(result).forEach(System.out::println);
        threadMethod();
    }

    private static void threadMethod() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread.getState().name());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isAlive());
        System.out.println(thread.getPriority());
        System.out.println(thread.isDaemon());
        System.out.println(thread.getId());
        System.out.println(thread.getId());
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

    public static int binarySearch(int[] array, int target) {
        int L = 0, R = array.length - 1, M = Math.round((L + R) / 2);

        while (L <= R) {
            M = Math.round((L + R) / 2);
            int potentialN = array[M];
            if (potentialN == target) {
                return M;
            } else if (potentialN > target) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return -1;
    }

    public static void OutputStream() {
        CharArrayWriter contactWriter = new CharArrayWriter();

        try (FileWriter bc1 = new FileWriter("business_card_1.txt", true);
             FileWriter bc2 = new FileWriter("business_card_2.txt", true)) {
            contactWriter.write("Phone: 111-222-333; Address: Java Avenue, 7");
            contactWriter.writeTo(bc1);
            contactWriter.writeTo(bc2);
            char[] array = contactWriter.toCharArray(); // writer content as char[]

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int L = 0, R = array.length - 1;

        while (L < R) {
            int sum = array[L] + array[R];
            if (sum > targetSum) {
                R--;
            } else if (sum < targetSum) {
                L++;
            } else {
                return new int[]{array[L], array[R]};
            }
        }

        return new int[0];
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
            String line = reader.readLine();
            String[] string = line.strip().split("\\s+");
            System.out.println(string[0].isEmpty() ? "0" : string.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char[] convert(String[] words) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (String str : words) {
            sb.append(str);
        }
        return sb.toString().toCharArray();
    }

}