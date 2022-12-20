class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        for(int i=0; i<n-2; i++){
            if(i==0 || (i!=0 && nums[i] != nums[i-1])){
                int sum = nums[i];
                int lo = i+1, hi = n-1;
                while(lo < hi){
                    if(nums[lo] + nums[hi] == 0-sum){
                        res.push_back(vector<int>{nums[i], nums[lo], nums[hi]});
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }else if(nums[lo] + nums[hi] < 0-sum){
                        lo++;
                    }else{
                        hi--;
                    }
                }
                    
            }
        }
        return res;
    }
};