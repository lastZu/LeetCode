/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode step = null;
        ListNode head = null;
        while (list1 != null || list2 != null) {
            if (listEquals(list1, list2)) {
                step = addNext(step, list1);
                list1 = list1.next;
            }else {
                step = addNext(step, list2);
                list2 = list2.next;
            }
            if (head == null) head = step;
        }
        return head;
    }

    private static boolean listEquals(ListNode x, ListNode y) {
        if (x == null) return false;
        if (y == null) return true;
        return x.val < y.val;
    }

    private static ListNode addNext(ListNode to, ListNode from) {
        ListNode node = new ListNode(from.val);
        if (to == null) {
            return node;
        }
        to.next = node;
        return to.next;
    }
}