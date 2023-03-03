package org.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 *     1 <= s.length, t.length <= 5 * 10^4
 *     s and t consist of lowercase English letters.
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> counter = new HashMap<>();
        char[] letters = s.toCharArray();
        for (char ch : letters) {
            Integer count = counter.getOrDefault(ch, 0);
            counter.put(ch, count + 1);
        }
        letters = t.toCharArray();
        for (char ch : letters) {
            Integer count = counter.getOrDefault(ch, 0);
            if (count == 0) return false;
            if (count == 1) {
                counter.remove(ch);
                continue;
            }
            counter.put(ch, count - 1);
        }
        if (counter.size() != 0) return false;
        return true;
    }

    public static boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sLetters = s.toCharArray();
        Arrays.sort(sLetters);
        char[] tLetters = t.toCharArray();
        Arrays.sort(tLetters);
        for (int i = 0; i < sLetters.length; i++) {
            if (sLetters[i] != tLetters[i]) return false;
        }
        return true;
    }

    public static boolean isAnagramSortingToString(String s, String t) {
        if (s.length() != t.length()) return false;
        String newS = sortString(s);
        String newT = sortString(t);
        return newT.equals(newS);
    }

    private static String sortString(String s) {
        char[] sLetters = s.toCharArray();
        Arrays.sort(sLetters);
        String newS = new String(sLetters);
        return newS;
    }
}
