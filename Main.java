import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] num1 = new int[] {4, 9, 5};
        int[] num2 = new int[] {9, 4, 9, 8, 4};
        int[] num = IntersectionOfTwoArrays2.intersect (num1, num2);
        System.out.println(Arrays.toString(num));
    }
}
