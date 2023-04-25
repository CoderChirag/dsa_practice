class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, curr_prefix_sum = 0;
        map.put(0, 1);
        for(int i=0; i<nums.length; i++){
            curr_prefix_sum += nums[i];
            
            int rem = curr_prefix_sum - k;
            
            count += map.getOrDefault(rem, 0);
            
            map.put(curr_prefix_sum, map.getOrDefault(curr_prefix_sum, 0)+1);
        }
        return count;
    }
}