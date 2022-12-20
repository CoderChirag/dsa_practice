class Solution {
public:
    bool isIdealPermutation(vector<int>& nums) {
        int n = nums.size();
        if(n == 1 || n == 2) return true;
        
        int m1 = nums[n-1];
        int index = n-3, i = n-2;
        while(index >= 0){
            if(nums[index] > m1) return false;
            index--;
            m1 = min(nums[i], m1);
            i--;
        }
        return true;
    }
};