class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<vector<int>> res;
        for(int i=0; i<n; i++){
            long long  target1 = target-nums[i];
            for(int j=i+1; j<n; j++){
                long long target2 = (long long)target1 - (long long)nums[j];
                
                int front = j+1, back = n-1;
                while(front < back){
                    if(nums[front] + nums[back] < target2) front++;
                    else if(nums[front] + nums[back] > target2) back--;
                    else{
                        vector<int> quad{nums[i], nums[j], nums[front], nums[back]};
                        res.push_back(quad);
                        while(front < back && nums[front] == quad[2]) ++front;
                        while(front < back && nums[back] == quad[3]) --back;
                    }
                }
                while(j+1 < n && nums[j] == nums[j+1])++j;
            }
            while(i+1 < n && nums[i] == nums[i+1]) ++i;
        }
        return res;
    }
};