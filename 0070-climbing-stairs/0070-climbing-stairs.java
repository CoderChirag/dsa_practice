// Brute Force - Recursion (Time Limit Exceeded) 
// class Solution {
//     public int climbStairs(int n) {
//         if(n == 0 || n == 1) return 1;
        
//         return climbStairs(n-1) + climbStairs(n-2); 
//     }
// }

// 1D DP
// class Solution {
//     public int climbStairs(int n) {
//         int a[] = new int[n+1];
//         a[0] = 1;
//         a[1] = 1;
//         for(int i=2; i<=n; i++){
//             a[i] = a[i-1] + a[i-2];
//         }
//         return a[n];
//     }
// }

// DP - Without extra space
class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1, res = 1;
        for(int i=1; i<n; i++){
            res = a+b;
            a = b;
            b = res;
        }
        return res;
    }
}