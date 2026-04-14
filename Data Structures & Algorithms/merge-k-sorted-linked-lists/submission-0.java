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
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((p, q) -> (p.val - q.val));
        
        ListNode sentinel = new ListNode(0);
        ListNode tail = sentinel;
        
        // add the start of each list to the queue
        for (ListNode node: lists)
            if (node != null)
                minHeap.add(node);
        
        // poll the queue and add the next element in the queue in case it is not null
        // also append the polled element to result list
        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
            
            if (tail.next != null)
                minHeap.add(tail.next);
        }
        return sentinel.next;

    }
}
