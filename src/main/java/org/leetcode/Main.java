package org.leetcode;

public class Main {
    public static void main(String[] args) {
        // main.java.org.leetcode.Trie test
        Trie trie = new Trie();

        trie.insert("asdf");
        var res0 = trie.search("as");
        var res1 = trie.search("asdf");
        var res2 = trie.startsWith("as");
        var res3 = trie.startsWith("ad");
        trie.insert("assd");
        var res4 = trie.search("assd");
        var res5 = trie.search("assdf");
        var res6 = trie.search("asdf");

        var res7 = trie.startsWith("ass");
        var res8 = trie.startsWith("d");

        // Find First and Last Position of Element in Sorted Array
//        int[] nums = new int[] {1, 3, 3, 4, 6, 9};
//        int[] fl11 = main.java.org.leetcode.FindFirstAndLastPositionOfElementInSortedArray.searchRange(new int[] {1}, 1);
//        int[] fl3 = main.java.org.leetcode.FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 3);
//        int[] fl1 = main.java.org.leetcode.FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 1);
//        int[] fl5 = main.java.org.leetcode.FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 5);
//        int[] flVoid = main.java.org.leetcode.FindFirstAndLastPositionOfElementInSortedArray.searchRange(new int[] {}, 3);


    }
}
