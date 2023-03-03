/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 *     Integers in each row are sorted from left to right.
 *     The first integer of each row is greater than the last integer of the previous row.
 *
 *     Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 *     Output: true
 *
 * Constraints:
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 100
 *     -10^4 <= matrix[i][j], target <= 10^4
 *
 */
public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        //mat[i] = matrix[i / col][i % col]
        int left = 0;
        int right = col * row - 1;
        int position = col * row / 2;
        while (left <= right) {
            int val = matrix[position / col][position % col];
            if (val > target) {
                right = position - 1;
            } else if (val < target) {
                left = position + 1;
            } else {
                return true;
            }
            position = (left + right) / 2;
        }
        return false;
    }
}
