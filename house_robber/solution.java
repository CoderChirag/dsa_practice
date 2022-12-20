class Solution {
   public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        int max_val = 0;
        for(int ele : nums){
            max_val = Math.max(ele + rob1, rob2);
            rob1 = rob2;
            rob2 = max_val;
        }
        return max_val;
    }
}