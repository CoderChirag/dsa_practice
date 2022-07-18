class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0], mF = nums[0];
        for(int i=1; i<nums.size(); i++){
            mF = max(mF + nums[i], nums[i]);
            res = max(res, mF);
        }
        return res;
    }
};