import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long M = sc.nextLong();

        long factorial = 1;
        long counter = 1;

        while (factorial <= M) {
            counter++;
            factorial *= counter;
        }
        System.out.println(counter);
    }
}
