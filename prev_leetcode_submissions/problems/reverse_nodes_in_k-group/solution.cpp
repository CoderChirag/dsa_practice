/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverse(ListNode* head, int k){
        ListNode* prev = NULL, *next = NULL, *curr = head;
        for(int i=0; i<k; i++){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* slow = head, *fast = head, *prevTail = NULL;
        while(slow){
            for(int i=0; i<k; i++){
                if(!fast->next && i != k-1){
                    if(prevTail) prevTail->next = slow;
                    return head;
                }
                fast = fast->next;
            }
            ListNode* newHead = reverse(slow, k);
            if(!prevTail) head = newHead;
            else prevTail->next = newHead;
            prevTail = slow;
            slow = fast;
        }
        return head;
    }
};