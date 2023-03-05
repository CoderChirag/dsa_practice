class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length, ele = nums[0], count = 1;
        for(int i=1; i<n; i++){
            if(nums[i] == ele) count++;
            else count--;
            if(count == 0){
                ele = nums[i];
                count = 1;
            }
        }
        count = 0;
        for(int e : nums){
            if(e == ele) count++;
        }
        return count > n/2 ? ele : -1;
    }
}