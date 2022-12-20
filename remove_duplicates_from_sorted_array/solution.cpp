class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        if(n < 2) return n;
        int i = -1, j = 1;
        while(j<n && nums[j] != nums[j-1]) j++;
        if(j == n) return n;
        i = j;
        j++;
        while(j < n){
            if(nums[j] != nums[i] && nums[j] != nums[j-1]){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
};