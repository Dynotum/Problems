import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int n2 = (int) Math.pow(size, 2);

        final int[][] matrix = fillMatrix(size, scanner);
        System.out.println(checkLine(matrix, n2) && chunks(matrix, size) ? "YES" : "NO");
    }

    private static boolean checkLine(int[][] matrix, int n2) {
        if (matrix.length == 1) {
            return matrix[0][0] == 1;
        }

        for (int n = 0; n < n2; n++) {
            final List<Integer> rangeHorizontal = IntStream.rangeClosed(1, n2)
                    .boxed().collect(Collectors.toList());
            final List<Integer> rangeVertical = IntStream.rangeClosed(1, n2)
                    .boxed().collect(Collectors.toList());
            for (int m = 0; m < n2; m++) {

                // horizontal
                if (rangeHorizontal.contains(matrix[n][m])) {
                    rangeHorizontal.remove(Integer.valueOf(matrix[n][m]));
                } else {
                    return false;
                }
                // vertical
                if (rangeVertical.contains(matrix[m][n])) {
                    rangeVertical.remove(Integer.valueOf(matrix[m][n]));
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean chunks(int[][] matrix, int squares) {

        int size = matrix.length / squares * (matrix[0].length / squares);
        List<int[][]> subArrays = new ArrayList<>();

        for (int n = 0; n < size; n++) {
            int[][] sub = new int[squares][squares];
            int startx = (squares * (n / squares)) % matrix.length;
            int starty = (squares * n) % matrix[0].length;

            if (starty + squares > matrix[0].length) {
                starty = 0;
            }
            if (startx + squares > matrix.length) {
                continue;
            }

            final List<Integer> rangeSquare = IntStream.rangeClosed(1, (int) Math.pow(squares, 2))
                    .boxed().collect(Collectors.toList());
            for (int row = 0; row < squares; row++) {
                for (int col = 0; col < squares; col++) {
                    sub[row][col] = matrix[startx + row][col + starty];

                    if (rangeSquare.contains(sub[row][col])) {
                        rangeSquare.remove(Integer.valueOf(sub[row][col]));
                    } else {
                        return false;
                    }

                }
            }
            subArrays.add(sub);
        }
        return true;
    }

    private static int[][] fillMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size * size][size * size];

        for (int n = 0; n < matrix.length; n++) {
            final String input = scanner.nextLine();
            matrix[n] = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
