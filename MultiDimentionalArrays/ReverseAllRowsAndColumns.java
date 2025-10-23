package MultiDimentionalArrays;

public class ReverseAllRowsAndColumns {

    // Reverses each row and then each column of a given 2D matrix in-place.
    public static void reverseRowsAndColumns(int[][] mat) {
        // --- Part 1: Reverse elements row-wise ---
        // Loop through each row of the matrix.
        for (int row = 0; row < mat.length; row++) {
            // Use two pointers, 'start' at the beginning and 'end' at the last element.
            int start = 0, end = mat[row].length - 1;

            // Swap elements until the pointers meet or cross.
            while (start < end) {
                int temp = mat[row][start];
                mat[row][start] = mat[row][end];
                mat[row][end] = temp;
                start++;
                end--;
            }
        }

        // --- Part 2: Reverse elements column-wise ---
        // Loop through each column of the matrix.
        // We assume all rows have the same length, so we check mat[0].length.
        for (int col = 0; col < mat[0].length; col++) {
            // Use two pointers, 'top' at the first row and 'bottom' at the last row.
            int top = 0, bottom = mat.length - 1;

            // Swap elements until the pointers meet or cross.
            while (top < bottom) {
                int temp = mat[top][col];
                mat[top][col] = mat[bottom][col];
                mat[bottom][col] = temp;
                top++;
                bottom--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 2, 8, 3, 4, 7 }, { 7, 2, 1, 6, 3 }, { 5, 5, 4, 1, 4 }, { 3, 1, 8, 2, 6 } };

        // Call the function to modify the matrix in-place.
        reverseRowsAndColumns(mat);

        // --- Print the modified matrix ---
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
