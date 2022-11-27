import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] num = new int[] {1, 2, 3, 0, 0, 0};
        MergeSortedArray.mergeTail(
                num,
                3,
                new int[] {2, 5, 6},
                3);
        System.out.println(Arrays.toString(num));
    }
}
