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
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        
        // Reverse the linked list
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // Now process the reversed list
        ListNode newHead = prev;
        ListNode newCurrent = newHead;
        int maxVal = newHead.val;
        
        while (newCurrent != null && newCurrent.next != null) {
            if (newCurrent.next.val < maxVal) {
                newCurrent.next = newCurrent.next.next;
            } else {
                maxVal = newCurrent.next.val;
                newCurrent = newCurrent.next;
            }
        }
        
        // Reverse the list again to restore original order
        ListNode finalHead = null;
        current = newHead;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = finalHead;
            finalHead = current;
            current = next;
        }
        
        return finalHead;
    }
}
