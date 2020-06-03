import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int help = 0;
        int result = 0;
        int elememt;
        int finalValue = -1;


        for (int i = 0; i < size; i++) {
            elememt = Integer.parseInt(sc.nextLine());

            if (elememt % 4 == 0 && result < (elememt / 4)) {
                result = (elememt / 4);
                finalValue = elememt;
            }
        }
        System.out.println(finalValue);
    }
}
