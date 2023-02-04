import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 *     Trie() Initializes the trie object.
 *     void insert(String word) Inserts the string word into the trie.
 *     boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 *     boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 * Constraints:
 *
 *     1 <= word.length, prefix.length <= 2000
 *     word and prefix consist only of lowercase English letters.
 *     At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
 *
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Trie {
    private boolean end;
    private final Map<Character, Trie> nextLetters;

    public Trie() {
        nextLetters = new HashMap<>();
    }

    public void insert(String word) {
        Trie step = this;
        for (char ch : word.toCharArray()) {
            Trie nextTrie = step.nextLetters.get(ch);
            if (nextTrie == null) {
                nextTrie = new Trie();
                step.nextLetters.put(ch, nextTrie);
            }
            step = nextTrie;
        }
        step.end = true;
    }

    public boolean search(String word) {
        Trie step = this;
        for (char ch : word.toCharArray()) {
            step = step.nextLetters.get(ch);
            if (step == null) {
                return false;
            }
        }
        return step.end;
    }

    public boolean startsWith(String prefix) {
        Trie step = this;
        for (char ch : prefix.toCharArray()) {
            step = step.nextLetters.get(ch);
            if (step == null) {
                return false;
            }
        }
        return true;
    }
}
