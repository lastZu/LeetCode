import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 *
 *     1 <= numRows <= 30
 */

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> tempRow = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        answer.add(row);
        for (int i = 2; i <= numRows; i++) {
            row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < tempRow.size(); j++) {
                row.add(tempRow.get(j) + tempRow.get(j - 1));
            }
            row.add(1);
            tempRow = row;
            answer.add(row);
        }
        return answer;
    }
}
