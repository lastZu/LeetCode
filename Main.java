import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] num1 = new int[] {4, 9, 5, 1, 2, 3, 1, 5, 10};
        int[] num2 = new int[] {9, 4, 9, 8, 4};
        int num = BestTimeToBuyAndSellStock.maxProfit (num1);
        System.out.println(num);
    }
}
