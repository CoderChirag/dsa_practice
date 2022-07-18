class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        int res = nums[1] - nums[0], minVal = nums[0];
        for(int j=1; j<nums.size(); j++){
            res = max(res, nums[j] - minVal);
            minVal = min(nums[j], minVal);
        }
        return res > 0 ? res : -1;
    }
};