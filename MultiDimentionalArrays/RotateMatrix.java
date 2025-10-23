package MultiDimentionalArrays;

public class RotateMatrix {

    // Rotates a square matrix 90 degrees clockwise in-place.
    public static void rotateMatrix(int[][] mat) {
        // --- Step 1: Transpose the matrix ---
        // Swap mat[i][j] with mat[j][i]
        for (int i = 0; i < mat.length; i++) {
            // Start j from i to only process the upper triangle of the matrix.
            for (int j = i; j < mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        // --- Step 2: Reverse each row ---
        // Loop through each row of the transposed matrix.
        for (int row = 0; row < mat.length; row++) {
            // Use two pointers to reverse the elements in the current row.
            int left = 0, right = mat[row].length - 1;
            while (left < right) {
                int temp = mat[row][left];
                mat[row][left] = mat[row][right];
                mat[row][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 2, 8, 3, 4 }, { 7, 2, 1, 6 }, { 5, 5, 4, 1 }, { 3, 1, 8, 2 } };

        // Call the function to rotate the matrix in-place.
        rotateMatrix(mat);

        // --- Print the rotated matrix ---
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
