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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2, res = new ListNode(), curr = res;
        int carry = 0;
        while(h1 != null || h2 != null){
            int n1 = h1 == null ? 0 : h1.val, n2 = h2 == null ? 0 : h2.val;
            int sum = n1 + n2 + carry;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            carry = sum/10;
            if(h1 != null) h1 = h1.next;
            if(h2 != null) h2 = h2.next;
        }
        if(carry != 0) curr.next = new ListNode(carry);
        return res.next;
    }
}