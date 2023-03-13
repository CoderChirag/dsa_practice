class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int curr = 0;
        for(int i=0; i<n; i++){
            if(i == 0 || nums[i] > nums[curr-1]) nums[curr++] = nums[i];
        }
        return curr;
    }
}