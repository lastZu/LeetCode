/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 *     Integers in each row are sorted in ascending from left to right.
 *     Integers in each column are sorted in ascending from top to bottom.
 *
 * Constraints:
 *
 *      m == matrix.length
 *      n == matrix[i].length
 *      1 <= n, m <= 300
 *      -10^9 <= matrix[i][j] <= 10^9
 *  All the integers in each row are sorted in ascending order.
 *  All the integers in each column are sorted in ascending order.
 *      -10^9 <= target <= 10^9
 *
 */
public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int stepRow = row / 2;

        for (int i = 0; i < col; i++) {
            if (target < matrix[0][i]) {
                break;
            }
            int left = 0;
            int right = row - 1;
            while (left <= right) {
                if (target > matrix[stepRow][i]) {
                    left = stepRow + 1;
                } else if (target < matrix[stepRow][i]) {
                    right = stepRow - 1;
                } else {
                    return true;
                }
                stepRow = (left + right) / 2;
            }
        }
        return false;
    }
}
