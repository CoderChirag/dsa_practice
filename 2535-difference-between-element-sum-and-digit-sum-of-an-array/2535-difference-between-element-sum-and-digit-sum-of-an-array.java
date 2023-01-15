class Solution {
    public int differenceOfSum(int[] nums) {
        int s1 =0, s2 = 0;
        for(int i=0; i<nums.length; i++){
            s1 += nums[i];
            while(nums[i] > 0){
                s2 += nums[i]%10;
                nums[i] /= 10;
            }
        }
        return Math.abs(s1-s2);
    }
}