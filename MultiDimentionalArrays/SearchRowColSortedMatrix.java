package MultiDimentionalArrays;

public class SearchRowColSortedMatrix {

    // Searches for 'x' in a row and column-wise sorted matrix.
    // This method uses a staircase search approach (starting from top-right).
    // Time Complexity: O(n + m)
    // Auxiliary Space: O(1)
    public static boolean search(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;

        // Start search from the top-right corner of the matrix
        // (We can start from bottom-left corner too)
        // (The conditions will change accordingly)
        int i = 0, j = m - 1;

        // Loop as long as the pointers are within the matrix bounds
        while (j >= 0 && i < n) {
            if (x == mat[i][j])
                return true; // Target element found

            else if (x < mat[i][j])
                j--; // Target is smaller, so move left (eliminate the current column

            else // x > mat[i][j]
                i++; // Target is larger, so move down (eliminate the current row)
        }

        // If the loop finishes, the element was not found
        return false;

    }

    public static void main(String[] args) {
        // Define the test matrix (must be row and column-wise sorted)
        int[][] mat = { { 3, 30, 38 }, { 20, 52, 54 }, { 35, 60, 69 } };
        int target = 62; // The element to search for

        // Call the search function
        Boolean search = search(mat, target);

        // Print the result (true or false)
        System.out.println(search);
    }
}
