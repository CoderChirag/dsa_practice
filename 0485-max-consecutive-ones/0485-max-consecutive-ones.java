class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr_streak = 0, max_streak = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1) curr_streak++;
            else{
                max_streak = Math.max(curr_streak, max_streak);
                curr_streak = 0;
            }
        }
        max_streak = Math.max(curr_streak, max_streak);
        return max_streak;
    }
}