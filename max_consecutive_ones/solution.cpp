class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int n = nums.size();
        int maxx = 0, curr_max = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1) curr_max++;
            else{
                maxx = max(curr_max, maxx);
                curr_max = 0;
            }
        }
        maxx = max(maxx, curr_max);
        return maxx;
    }
};