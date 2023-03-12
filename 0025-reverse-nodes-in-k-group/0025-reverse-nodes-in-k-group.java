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
    
    public ListNode reverse(ListNode head, int k){
        ListNode prev = null, curr = head;
        for(int i=0; i<k; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, slow = head, fast = head, next = null, prev = null;
        int len = 0;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        for(int i=0; i<len/k; i++){
            for(int j=0; j<k-1; j++){
                fast = fast.next;
            }
            next = fast.next;
            reverse(slow, k);
            if(i == 0) head = fast;
            if(prev != null) prev.next = fast;
            prev = slow;
            slow = fast = next;
        }
        if(prev != null) prev.next = slow;
        return head;
    }
}