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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq= new PriorityQueue<>(
            new Comparator<ListNode>(){
                @Override
                public int compare(ListNode o1,ListNode o2){
                    if(o1.val>o2.val)
                    return 1;
                    else if(o1.val==o2.val)
                    return 0;
                    else
                     return -1;
                }
            }
        );
        // add first element of lists in priority queue
        for(ListNode node : lists){
            if(node!=null)
            pq.offer(node);
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!pq.isEmpty()){
            
            ListNode minItem = pq.poll();
            if(minItem.next!=null)
            pq.offer(minItem.next);
            point.next = minItem;
            point=point.next;


        }
        return head.next;
        
    }
}