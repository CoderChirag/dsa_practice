class Solution {
public:
    int max1, max2, sum;
    int maxSubArrayRecursive(vector<int>& nums, int l, int r){
        if(l < r){
            int mid = (l+r)/2;
            // int curr_sum += nums[mid];
            int lMax = maxSubArrayRecursive(nums, l, mid);
            int rMax = maxSubArrayRecursive(nums, mid+1, r);
            max1 = INT_MIN, sum = 0, max2 = INT_MIN;
            for(int i=mid; i>=l; i--){
                sum += nums[i];
                max1 = max(sum, max1);
            }
            sum = 0;
            for(int i=mid+1; i<=r; i++){
                sum += nums[i];
                max2 = max(sum, max2);
            }
            max1 = max(max1+max2, max(lMax, rMax));
        }else{
            max1 = nums[l];
        }
        return max1;
    }
    int maxSubArray(vector<int>& nums) {
        return maxSubArrayRecursive(nums, 0, nums.size()-1);
    }
};