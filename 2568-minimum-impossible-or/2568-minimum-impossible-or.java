class Solution {
    public int minImpossibleOR(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > res) return res;
            else if(nums[i] == res) res *= 2;
        }
        return res;
    }
}