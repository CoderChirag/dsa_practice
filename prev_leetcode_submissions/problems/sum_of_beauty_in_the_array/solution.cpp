class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        int n = nums.size();
        int lMax[n], rMin[n];
        int curr_max = INT_MIN;
        for(int i=0; i<n; i++){
            curr_max = max(curr_max, nums[i]);
            lMax[i] = curr_max;
        }
        int curr_min = INT_MAX;
        for(int i=n-1; i>=0; i--){
            curr_min = min(curr_min, nums[i]);
            rMin[i] = curr_min;
        }
        int res = 0;
        for(int i=1; i<n-1; i++){
            if(nums[i] > lMax[i-1] && nums[i] < rMin[i+1]) res += 2;
            else if(nums[i] > nums[i-1] && nums[i] < nums[i+1]) res++;
        }
        return res;
    }
};