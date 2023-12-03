function climbStairs(n: number): number {
    let prev = 1, prev2 = 1, curr = 1;
    for(let i=1; i<n; i++){
        curr = prev + prev2;
        prev2 = prev;
        prev = curr;
    }
    return curr;
};