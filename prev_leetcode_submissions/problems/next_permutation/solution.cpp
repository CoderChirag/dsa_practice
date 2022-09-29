class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        if( n == 0 || n == 1) return;
        int i = n-2;
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        int j = i;
        if(i >=0){
            while(i < n-1 && nums[j] < nums[i+1]){
                i++;
            }
            swap(nums[j], nums[i]);
        }
        reverse(nums.begin()+j+1, nums.end());
    }
};