class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int res = nums[0];
        int maxSum = nums[0], minSum = nums[0];
        for(int i=1; i<nums.size(); i++){
            if(nums[i] < 0) swap(maxSum, minSum);
            maxSum = max(maxSum*nums[i], nums[i]);
            minSum = min(minSum*nums[i], nums[i]);
            res = max(res, maxSum);
        }
        return res;
    }
};