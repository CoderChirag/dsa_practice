class Solution {
    public int maxProduct(int[] nums) {
        int curr_max = nums[0], curr_min = nums[0], res = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] < 0){
                int temp = curr_min;
                curr_min = curr_max;
                curr_max = temp; 
            }
            curr_max = Math.max(curr_max*nums[i], nums[i]);
            curr_min = Math.min(curr_min*nums[i], nums[i]);
            res = Math.max(res, curr_max);
        }
        return res;
    }
}