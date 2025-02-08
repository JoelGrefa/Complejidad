import java.util.Random;

public class MatrixUtils {
    public static void fillMatrixWithRandomValues(int[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(201) - 100;  // Números aleatorios entre -100 y 100
            }
        }
    }

    public static int[] flattenMatrix(int[][] matrix) {
        int[] flat = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                flat[index++] = matrix[i][j];
            }
        }
        return flat;
    }

    public static int calculateSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
