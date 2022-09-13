/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* slow = head, *fast = head, *entry = head;
        do{
            if(slow){
                slow = slow->next;
            }
            if(fast && fast->next){
                fast = fast->next->next;
            }
        }while(fast && fast->next && slow != fast);
        if(!fast || !fast->next) return NULL;
        while(slow != entry){
            slow = slow->next;
            entry = entry->next;
        }
        return slow;
    }
};