class Solution {
public:
    int fact(int n){
        int res = 1;
        for(int i=1; i<=n; i++){
            res *= i;
        }
        return res;
    }
    vector<int> nextPermutation(vector<int> nums){
        int n = nums.size();
        int i = n - 2;
        while(i >=0 && nums[i] >= nums[i+1])i--;
        if(i >= 0){
            int j = n-1;
            while(nums[j] <= nums[i])j--;
            swap(nums[i], nums[j]);
        }
        reverse(nums.begin()+i+1, nums.end());
        return nums;
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        int n = nums.size();
        int maxLength = fact(n);
        res.push_back(nums);
        for(int i=0; i<maxLength-1; i++){
            res.push_back(nextPermutation(res.back()));
        }
        return res;
    }
};