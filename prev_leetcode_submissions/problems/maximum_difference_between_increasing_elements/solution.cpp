class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        int minVal = nums[0], res = nums[1] - nums[0];
        for(int i=1; i<nums.size(); i++){
            res = max(res, nums[i] - minVal);
            minVal = min(minVal, nums[i]);
        }
        return res > 0 ? res : -1;
    }
};