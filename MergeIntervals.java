import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 *     1 <= intervals.length <= 10^4
 *     intervals[i].length == 2
 *     0 <= starti <= endi <= 10^4
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> ansver = new ArrayList<>();

        Comparator<int[]> comparatorByStart = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        };
        Arrays.sort(intervals, comparatorByStart);
        int[] temp = new int[]{intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
                continue;
            }
            ansver.add(temp);
            temp = new int[]{intervals[i][0], intervals[i][1]};
        }
        ansver.add(temp);
        return ansver.toArray(new int[0][0]);
    }
}
