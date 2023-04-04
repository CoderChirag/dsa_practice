class Solution {
    public void moveZeroes(int[] nums) {
        int curr = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[curr];
                nums[curr] = nums[i];
                nums[i] = temp;
                curr++;
            }
        }
    }
}