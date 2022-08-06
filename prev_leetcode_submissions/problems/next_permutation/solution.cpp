class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int i = n-1;
        while(i >= 1){
            if(nums[i] > nums[i-1]) break;
            i--;
        }
        if(i == 0){
            reverse(nums.begin(), nums.end());
            return;
        }
        int j = i;
        while(j+1 < n && nums[j+1] > nums[i-1]){
            j++;
        }
        swap(nums[j], nums[i-1]);
        reverse(nums.begin() + i, nums.end());
    }
};