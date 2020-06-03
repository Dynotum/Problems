import java.util.*;

public class Main {
    public static void main(String[] args) {
        final char[][] matrix = fillMatrix();
        System.out.println(checkPattern(matrix) ? "YES" : "NO");
    }

    private static char[][] fillMatrix() {
        Scanner sc = new Scanner(System.in);
        char[][] matrix = new char[4][4];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        return matrix;
    }


    private static boolean checkPattern(char[][] matrix) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == matrix[i][j + 1] &&
                    matrix[i][j] == matrix[i + 1][j] &&
                    matrix[i][j] == matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}