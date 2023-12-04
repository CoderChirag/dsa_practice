function rec(n: number, nums: number[], dp: number[]){
    if(dp[n] !== -1) return dp[n];
    if(n == 0){
        dp[0] = nums[0];
        return nums[0];
    }
    if(n == 1){
        dp[1] = Math.max(nums[0], nums[1]);
        return Math.max(nums[0], nums[1]);
    }
    const res = Math.max(rec(n-2, nums, dp) + nums[n], rec(n-1, nums, dp));
    dp[n] = res;
    return res;
}

function rob(nums: number[]): number {
    if(nums.length === 1) return nums[0];
    if(nums.length === 2)  return Math.max(nums[0], nums[1]);
    return Math.max(rec(nums.length-2, nums.slice(0, nums.length-1), new Array(nums.length).fill(-1)), rec(nums.length-2, nums.slice(1, nums.length), new Array(nums.length).fill(-1)));
};