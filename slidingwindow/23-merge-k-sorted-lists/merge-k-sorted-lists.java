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
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l2== null)
        return l1;
        else if(l1==null)
        return l2;
        else if(l1.val>l2.val){
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
        else
        {
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
        return null;
        ListNode head = lists[0];
        for(int i=1;i<lists.length;i++){
            head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }
}