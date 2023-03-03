package org.leetcode;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 *
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 *
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 *
 * Constraints:
 *
 *     1 <= num1.length, num2.length <= 10^4
 *     num1 and num2 consist of only digits.
 *     num1 and num2 don't have any leading zeros except for the zero itself.
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder newNum = new StringBuilder();
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();

        int maxLength = num1Chars.length > num2Chars.length ? num1Chars.length : num2Chars.length;
        int temp = 0;
        for (int i = 0; i < maxLength; i++) {
            int n1 = 0 <= num1Chars.length - i - 1 ? Character.digit(num1Chars[num1Chars.length - i - 1], 10) : 0;
            int n2 = 0 <= num2Chars.length - i - 1 ? Character.digit(num2Chars[num2Chars.length - i - 1], 10) : 0;
            int sum = n1 + n2 + temp;
            temp = 0;
            if (sum >= 10) {
                temp = 1;
                sum = sum % 10;
            }
            newNum.append(sum);
        }
        if (temp == 1) {
            newNum.append(temp);
        }
        return newNum.reverse().toString();
    }
}
