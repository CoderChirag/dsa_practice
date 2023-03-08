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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        if(n > len) return head;
        else if(n == len && head != null) return head.next;
        curr = head;
        while(len > n+1){
            len--;
            curr = curr.next;
        }
        if(curr != null && curr.next != null) curr.next = curr.next.next;
        return head;
    }
}