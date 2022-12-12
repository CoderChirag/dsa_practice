// Brute Force - Time Limit Exceeded
// class Solution {
//     public int countWays(int n, int i){
//         if(i > n) return 0;
//         if(i == n) return 1;
//         return countWays(n, i+1) + countWays(n, i+2);
//     }
//     public int climbStairs(int n) {
//         return countWays(n, 0);
//     }
// }

class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1, c = 1;
        for(int i=2; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}