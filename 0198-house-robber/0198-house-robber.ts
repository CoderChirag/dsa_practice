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
    if(nums.length === 1) return nums[0];
    let prev2 = nums[0];
    let prev = Math.max(nums[0], nums[1]);
    let curr = prev;
    for(let i=2; i<nums.length; i++){
        curr = Math.max(nums[i] + prev2, prev);
        prev2 = prev;
        prev = curr;
    }
    return curr;
};