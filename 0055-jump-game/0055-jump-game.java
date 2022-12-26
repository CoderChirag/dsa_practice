class Solution {
    public boolean canJump(int[] nums) {
        int max_reachable = 0;
        for(int i=0; i<nums.length-1; i++){
            if(max_reachable < i) break;
            
            max_reachable = Math.max(max_reachable, nums[i]+i);
        }
        return max_reachable >= nums.length-1 ? true : false; 
    }
}