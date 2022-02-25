class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0];
        int maxEnding = 0;
        for(int i=0; i<nums.size(); i++){
            maxEnding = max(maxEnding + nums[i], nums[i]);
            res = max(maxEnding, res);
        }
        return res;
    }
};