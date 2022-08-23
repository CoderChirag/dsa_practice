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
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        set<vector<int>> res;
        vector<int> lastPerm(nums);
        int n = nums.size();
        int maxLength = fact(n);
        res.insert(nums);
        for(int i=0; i<maxLength-1; i++){
            vector<int> nextPerm = nextPermutation(lastPerm); 
            res.insert(nextPerm);
            lastPerm = nextPerm;
        }
        return vector<vector<int>>(res.begin(), res.end());
    }
};