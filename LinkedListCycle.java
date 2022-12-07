/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode first = head;
        ListNode second = head.next;

        while (second.next != null && second.next.next != null) {
            if (second == first) return true;
            first = first.next;
            second = second.next.next;
        }
        return false;
    }
}
