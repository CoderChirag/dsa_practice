class Solution {
public:
    void sortColors(vector<int>& nums) {
        int pos = 0;
        for(int i=0; i<nums.size(); i++){
            if(nums[i] == 0){
                swap(nums[i], nums[pos]);
                pos++;
            }
        }
        for(int i=pos; i<nums.size(); i++){
            if(nums[i] == 1){
                swap(nums[i], nums[pos]);
                pos++;
            }
        }
    }
};