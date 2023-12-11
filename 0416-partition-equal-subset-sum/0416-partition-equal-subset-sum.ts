// function rec(i: number, target: number, dp: Array<Array<number>>, nums: number[]){
//     if(target === 0){
//         dp[i][target] = 1;
//         return true;
//     }
//     if(i === 0){
//         dp[i][target] = target === nums[i] ? 1 : 0;
//         return target === nums[i];
//     }
//     if(dp[i][target] !== -1) return dp[i][target] === 1 ? true : false;
//     let taken = false, notTaken = rec(i-1, target, dp, nums);
//     if(nums[i] <= target){
//         taken = rec(i-1, target-nums[i], dp, nums);
//     }
//     dp[i][target] = taken || notTaken ? 1 : 0;
//     return taken || notTaken;
// }

function canPartition(nums: number[]): boolean {
    const n = nums.length;
    let sum = 0;
    for(let i=0; i<n; i++)
        sum += nums[i];
    if(sum % 2 !== 0)
        return false;
    sum = sum/2;
    let prev = new Array(sum+1).fill(false);
    prev[0] = true;
    for(let i=0; i<n; i++){
        const curr = new Array(sum+1).fill(false);
        curr[0] = true;
        for(let target=sum; target>0; target--){
            if(i === 0){
                curr[target] = target === nums[i] ? true : false;
                continue;
            }
            let taken = false, notTaken = prev[target];
            if(nums[i] <= target)
                taken = prev[target-nums[i]];
            curr[target] = taken || notTaken;
        }
        prev = curr;
    }
    return prev[sum];
};