class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int curr_cnt = 1, curr_ele = nums[0];
        for(int i=1; i<nums.size(); i++){
            if(nums[i] == curr_ele) curr_cnt++;
            else curr_cnt--;
            if(curr_cnt == 0){
                curr_ele = nums[i];
                curr_cnt = 1;
            }
        }
        return curr_ele;
    }
};