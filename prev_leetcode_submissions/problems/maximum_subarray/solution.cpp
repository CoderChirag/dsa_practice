class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0, mF = nums[0];
        for(int i=0; i<nums.size(); i++){
            sum += nums[i];
            mF = max(mF, sum);
            if(sum < 0) sum = 0;
        }
        return mF;
    }
};