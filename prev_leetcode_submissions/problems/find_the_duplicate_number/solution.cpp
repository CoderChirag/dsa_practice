class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int n = nums.size();
        for(int i=0; i<n; i++){
            nums[(nums[i]%(n+1))-1] += n+1;
        }
        for(int i=0; i<n; i++){
            if(nums[i]/(n+1) > 1){
                return i+1;
            }
        }
        return -1;
    }
};