import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String[] input = sc.nextLine().split(" ");
        final int n = Integer.parseInt(input[0]);
        final int m = Integer.parseInt(input[1]);

        final int[][] matrix = getNumbers(n, m, sc);

        startGame(matrix, n, m);

    }

    private static int[][] getNumbers(int n, int m, Scanner sc) {


        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            final String[] rowNumber = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(rowNumber[j]);
            }
        }
        return matrix;
    }

    private static void startGame(int[][] matrix, int nSize, int mSize) {
        int result = Integer.MIN_VALUE;
        int smallestN = Integer.MAX_VALUE;
        int smallestM = Integer.MAX_VALUE;

        for (int nN = 0; nN < nSize; nN++) {
            for (int mM = 0; mM < mSize; mM++) {

                if (result == matrix[nN][mM]) {
                    if (smallestN > nN) {
                        smallestN = nN;
                        smallestM = mM;
                    }

                    if (smallestN == nN && smallestM > mM) {
                        smallestN = nN;
                        smallestM = mM;
                    }
                }

                if (result < matrix[nN][mM]) {
                    result = matrix[nN][mM];
                    smallestN = nN;
                    smallestM = mM;
                }
            }
        }
        System.out.println(smallestN + " " + smallestM);
    }
}