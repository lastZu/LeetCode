import java.util.*;

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

    public static int[][] merge2(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[1]);
        }
        int[] starts = new int[max + 1];
        int[] ends = new int[max + 1];

        for (int[] interval : intervals) {
            starts[interval[0]] += 1;
            ends[interval[1]] += 1;
        }
        List<int[]> ansver = new ArrayList<>();
        int[] temp = new int[2];
        int openCloseCounter = -1;
        for (int i = 0; i <= max; i++) {
            if (starts[i] > 0 && openCloseCounter <= 0) {
                if (openCloseCounter != -1) {
                    ansver.add(temp);
                }
                temp = new int[2];
                temp[0] = i;
                if (openCloseCounter == -1) openCloseCounter = 0;
            }
            if (ends[i] > 0) {
                temp[1] = i;
            }
            if (starts[i] > 0) openCloseCounter += starts[i];
            if (ends[i] > 0) openCloseCounter -= ends[i];
        }
        ansver.add(temp);
        return ansver.toArray(new int[0][0]);
    }
}
