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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* currA = headA, *currB = headB;
        int lenA = 0, lenB = 0;
        while(currA || currB){
            if(currA){
                currA = currA->next;
                lenA++;
            }
            if(currB){
                currB = currB->next;
                lenB++;
            }
        }
        currA = headA, currB = headB;
        for(int i=0; i<abs(lenA-lenB); i++){
            if(lenA > lenB){
                currA = currA->next;
            }else{
                currB = currB->next;
            }
        }
        while(currA && currB && currA != currB){
            currA = currA->next;
            currB = currB->next;
        }
        return currA;
    }
};