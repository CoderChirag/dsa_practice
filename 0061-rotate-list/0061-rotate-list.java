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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode curr = head, res = new ListNode();
        int n = 0;
        while(curr != null){
            n++;
            curr = curr.next;
        }
        k %= n;
        if(k == 0) return head;
        curr = head;
        for(int i=0; i<n-k-1; i++){
            curr = curr.next;
        }
        res.next = curr.next;
        curr.next = null;
        curr = res.next;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = head;
        return res.next;
    }
}