class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) set.add(nums[i]);
        
        int longest_streak = 0;
        
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(!set.contains(num-1)){
                int curr_streak = 1;
                while(set.contains(num+1)){
                    curr_streak++;
                    num++;
                }
                longest_streak = Math.max(longest_streak, curr_streak);
            }
        }
        return longest_streak;
    }
}