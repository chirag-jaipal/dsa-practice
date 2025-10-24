package MultiDimentionalArrays;

public class SearchInSortedMatrix {

    // Searches for a target in a sorted m x n matrix (LeetCode 74).
    // The matrix is treated as a flattened, sorted 1D array of size m * n.
    // This allows for a single binary search.
    // Time Complexity: O(log(m * n))
    // Auxiliary Space: O(1)
    public static boolean searchMatrix(int[][] mat , int target) {
        int m = mat.length, n = mat[0].length;

        // Treat the m x n matrix as a sorted 1D array of size m * n
        int low = 0, high = m * n - 1;

        // Standard binary search on the virtual 1D array
        while (low <= high) {
            // Calculate the 1D middle index
            int mid = low + (high - low) / 2;

            // Convert the 1D 'mid' index back to 2D (row, col) coordinates
            int row = mid / n;
            int col = mid % n;

            if (target == mat[row][col]) 
                return true; // Target found

            else if (target < mat[row][col]) 
                high = mid - 1; // Search in the left half

            else // target > mat[row][col]
                low = mid + 1; // Search in the right half
        }

        // Target not found after the loop finishes
        return false;
    }

    public static void main(String[] args) {
        // Define the test matrix (rows sorted, next row > prev row)
        int[][] mat = { {1, 3, 5, 7 }, {10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;

        // Call the search function
        boolean ans = searchMatrix(mat, target);

        // Print the result
        System.out.println(ans); // Expected output: true
    }
}
