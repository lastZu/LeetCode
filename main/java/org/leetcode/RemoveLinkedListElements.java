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
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return head;
        ListNode step = head.next;
        ListNode back = head;
        while (step != null) {
            if (step.val == val) {
                remuveNode(step, back);
                step = back.next;
                continue;
            }
            back = back.next;
            step = step.next;
        }
        return head;
    }

    private static void remuveNode(ListNode node, ListNode back) {
        if (node.next == null) {
            back.next = null;
            return;
        }
        ListNode temp = node.next;
        back.next = temp;
    }
}
