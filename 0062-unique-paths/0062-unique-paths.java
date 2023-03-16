class Solution {
//     BFS Based Approach - Memory Limit Exceeded
    // public int uniquePaths(int m, int n) {
    //     ArrayDeque<Integer[]> q = new ArrayDeque<>();
    //     q.offer(new Integer[]{0, 0});
    //     int count = 0;
    //     while(!q.isEmpty()){
    //         Integer[] arr = q.poll();
    //         int x = arr[0], y = arr[1];
    //         if(x == m-1 && y == n-1){
    //             count++;
    //             continue;
    //         }
    //         if(y+1 < n) q.offer(new Integer[]{x, y+1});
    //         if(x+1 < m) q.offer(new Integer[]{x+1, y});
    //     }
    //     return count;
    // }
    
//     DFS Based Approach - Time Limit Exceeded (O(2^n))
//     public int uniquePathsRec(int i, int j, int m, int n){
//         if(i == m-1 && j == n-1) return 1;
//         if(i >= m || j >= n) return 0;
//         return uniquePathsRec(i, j+1, m, n) + uniquePathsRec(i+1, j, m, n);
//     }
    
//     public int uniquePaths(int m, int n) {
//         return uniquePathsRec(0, 0, m, n);
//     }
    
//  Dynamic Programming (Memoization) - O(n*m) Time & O(n*m) Space
//     public int uniquePathsRec(int i, int j, int m, int n, int[][] dp){
//         if(i == m-1 && j == n-1){
//             dp[i][j] = 1;
//             return 1;
//         };
//         if(i >= m || j >= n) return 0;
//         if(dp[i][j] != 0) return dp[i][j];
//         dp[i][j] = uniquePathsRec(i, j+1, m, n, dp) + uniquePathsRec(i+1, j, m, n, dp);
//         return dp[i][j];
//     }
    
//     public int uniquePaths(int m, int n) {
//         int dp[][] = new int[m][n];
//         return uniquePathsRec(0, 0, m, n, dp);
//     }
    
//  Combinatorics - O(m-1) Time and O(1) Space
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int r = m-1; // Can also be n-1
        double ncr = 1;
        // for(int i=1; i<=r; i++){
        //     ncr = (ncr*(N-r+i))/i;
        // }
        for(int i=0; i<N-r; i++){
            ncr *= (double)(N-i)/(i+1);
        }
        System.out.println(ncr); 
        return (int)Math.round(ncr);
    }
}