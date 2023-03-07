class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length, curr = 1, max = 1;
        if(n == 0) return 0;
        Arrays.sort(nums);
        for(int i=1; i<n; i++){
            if(nums[i] - nums[i-1] == 0) continue;
            else if(nums[i]-nums[i-1] == 1) curr++;
            else{
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        max = Math.max(max, curr);
        return max;
    }
}