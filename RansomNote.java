import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 *     1 <= ransomNote.length, magazine.length <= 10^5
 *     ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> frequency = new HashMap<>();
        char[] letters = magazine.toCharArray();
        for (char letter : letters) {
            Integer count = frequency.getOrDefault(letter, 0);
            frequency.put(letter, count + 1);
        }
//        var m = magazine
//                .chars()
//                .mapToObj(i -> (char) i)
//                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        char[] requiredLetters = ransomNote.toCharArray();
        for (char letter : requiredLetters) {
            Integer count = frequency.getOrDefault(letter, 0);
            if (count == 0) return false;
            frequency.put(letter, count - 1);
        }
        return true;
    }
}
