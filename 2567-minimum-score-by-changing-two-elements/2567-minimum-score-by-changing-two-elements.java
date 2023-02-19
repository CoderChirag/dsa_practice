class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length, res = 0;
        Arrays.sort(nums);
        res = nums[n-1] - nums[2];
        res = Math.min(res, nums[n-3] - nums[0]);
        res = Math.min(res, nums[n-2] - nums[1]);
        return res;
    }
}