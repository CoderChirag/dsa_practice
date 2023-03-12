/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode curr1 = headA, curr2 = headB;
        while(curr1 != null){
            l1++;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            l2++;
            curr2 = curr2.next;
        }
        curr1 = headA;
        curr2 = headB;
        int diff = Math.abs(l1-l2);
        if(l1 > l2){
            for(int i=0; i<diff; i++) curr1 = curr1.next;
        }else{
            for(int i=0; i<diff; i++) curr2 = curr2.next;
        }
        
        while(curr1 != null && curr2 != null && curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
        
    }
}