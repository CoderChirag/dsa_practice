class Solution {
public:
    vector<vector<int>> res;
    vector<vector<int>> subsets(vector<int>& nums, vector<int> curr, int i){
        if(i == nums.size()){
            res.push_back(curr);
            return res;
        }
        subsets(nums, curr, i+1);
        curr.push_back(nums[i]);
        subsets(nums, curr, i+1);
        return res;
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> curr;
        return subsets(nums, curr, 0);
    }
};