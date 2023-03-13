/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head, res = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }else{
                curr.next.random = null;
            }
            curr = curr.next.next;
        }
        curr = head;
        res = head.next;
        while(curr != null){
            Node next = curr.next.next;
            if(next != null){
                curr.next.next = next.next;
            }
            curr.next = next;
            curr = next;
        }
        return res;
    }
}