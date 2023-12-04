// function rec(n: number, nums: number[], dp: number[]){
//     if(n < 0){
//         return 0;
//     };
//     if(dp[n] !== -1) return dp[n];
//     const pick = rec(n-2, nums, dp) + nums[n];
//     const nonPick = rec(n-1, nums, dp);
//     dp[n] = Math.max(pick, nonPick);
//     return Math.max(pick, nonPick);
// }

function rob(nums: number[]): number {
    let dp = new Array(nums.length+1).fill(-1);
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for(let i=2; i<nums.length; i++){
        dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
    }
    return dp[nums.length-1];
};