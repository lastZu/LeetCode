package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 10^5
 *     s consists of only lowercase English letters.
 */
public class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] charFrequency = new int[26];
        for (int i = 0; i < chars.length; i++) {
            charFrequency[chars[i] - 'a'] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (charFrequency[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
//            Integer count = charFrequency.get(chars[i]);
//            if (count == null) {
//                count = 0;
//            }
//            charFrequency.put(chars[i], count + 1);