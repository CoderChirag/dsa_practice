function rec(n: number, nums: number[], dp: number[]){
    if(dp[n] !== -1) return dp[n];
    if(n === 0){
        dp[0] = nums[0];
        return nums[0];
    };
    let max_res = Number.MIN_VALUE;
    for(let i=n-2; i>=0; i--){
        max_res = Math.max(max_res, rec(i, nums, dp) + nums[n]);
    }
    const res = max_res === Number.MIN_VALUE ? nums[n] : max_res;
    dp[n] = res;
    return res;
}

function rob(nums: number[]): number {
    let max = Number.MIN_VALUE;
    let dp = new Array(nums.length).fill(-1);
    for(let i=nums.length-1; i>=0; i--){
        max = Math.max(max, rec(i, nums, dp));
    }
    return max;
};