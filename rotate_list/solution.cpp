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
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head) return NULL;
        ListNode* curr = head, *next = NULL;
        int n = 0;
        while(curr){
            n++;
            curr = curr->next;
        }
        k %= n;
        if(!k) return head;
        int d = n-k;
        curr = head;
        for(int i=0; i<d-1; i++){
            curr = curr->next;
        }
        next = curr->next;
        curr->next = NULL;
        curr = next;
        while(curr->next){
            curr = curr->next;
        }
        curr->next = head;
        return next;
    }
};