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
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head, *fast = head;
        ListNode* prev = NULL, *next = NULL, *curr = NULL;
        while(fast && fast->next){
                fast = fast->next->next;
                next = slow->next;
                slow->next = prev;
                prev = slow;
                slow = next;
        }
        curr = prev;
        if(fast){
            slow = slow->next;
        }
        while(curr){
            if(curr->val != slow->val) return false;
            curr = curr->next;
            slow = slow->next;
        }
        return true;
    }
};