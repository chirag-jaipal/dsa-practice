package MultiDimentionalArrays;

public class PrintSnakePattern {

    public static void snakePattern(int[][] mat) {
        // Iterate through each row of the matrix.
        for (int i = 0; i < mat.length; i++) {
            // Check if the current row index 'i' is even.
            if (i % 2 == 0) {
                // Even row: Print from left to right (j = 0 to end).
                for (int j = 0; j < mat[i].length; j++)
                    System.out.print(mat[i][j] + " ");
            }
            // If the row index 'i' is odd.
            else {
                // Odd row: Print from right to left (j = end to 0).
                for (int j = mat[i].length - 1; j >= 0; j--)
                    System.out.print(mat[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        // Define a 3x3 square matrix.
        int[][] matrix = { { 45, 48, 54 }, { 21, 8, 87 }, { 70, 78, 15 }};

        // Call the function to print the snake pattern.
        snakePattern(matrix);
    }
}
