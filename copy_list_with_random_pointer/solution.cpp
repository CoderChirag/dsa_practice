/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head) return NULL;
        Node* curr = head, *newCurr = NULL;
        while(curr){
            newCurr = new Node(curr->val);
            newCurr->next = curr->next;
            curr->next = newCurr;
            curr = newCurr->next;
        }
        curr = head;
        while(curr){
            if(curr->random){
                curr->next->random = curr->random->next;
            }else{
                curr->next->random = NULL;
            }
            
            curr = curr->next->next;
        }
        newCurr = head->next;
        curr = head;
        Node* newHead = head->next;
        while(newCurr && newCurr->next){
            curr->next = curr->next->next;
            curr = curr->next;
            newCurr->next = newCurr->next->next;
            newCurr = newCurr->next;
        }
        curr->next = NULL;
        return newHead;
    }
};