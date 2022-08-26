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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(!list1 && !list2) return NULL;
        ListNode* head = NULL, *a = NULL, *b = NULL, *curr = NULL;
        if(list1 && list2){
            if(list1->val < list2->val){
                head = list1;
                a = list1;
                b = list2;
            }else{
                head = list2;
                a = list2;
                b = list1;
            }
        }else if(list1){
            head = list1;
            a = list1;
        }else {
            head = list2;
            b = list2;
        }
        
        while(a && b){
            if(a->next && a->next->val > b->val){
                ListNode* temp = b;
                b = a->next;
                a->next = temp;
            }else{
                curr = a;
                a = a->next;
            }
        }
        // cout << b->val << endl; 
        if(curr && b){
            // cout << curr->val << endl;
            curr->next = b;
        }
        return head;
    }
};