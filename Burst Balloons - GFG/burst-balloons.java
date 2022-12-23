//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int dp[][]; // For Memoization
    
    public static int solve(int arr[], int i, int j){
        // Base Cases
        if(i > j) return 0;
        if(i == j){ // Only one element exists
            int res = arr[i];
            if(i > 0) res *= arr[i-1];
            if(i < arr.length-1) res *= arr[i+1];
            return res;
        }
        if(dp[i][j] != -1) return dp[i][j]; // Return if soulution is already memoized
        
        int ans = 0;
        // For all elements in the range i to j, we choose all of them one by one 
		// to make them the last balloon to be burst.
        for(int k=i; k<=j; k++){
            // Burst the kth balloon after bursting (i, k - 1) and (k + 1, j) balloons
            int res = arr[k];
            if(j < arr.length-1) res *= arr[j+1]; // As balloon j + 1 will become adjacent to k after bursting  k + 1 to j balloons
            if(i > 0) res *= arr[i-1]; // As balloon i- 1 will become adjacent to k after bursting  i  to k -1 balloons
            
            // Recursively solve the left and right subproblems and add their contribution
            res += solve(arr, i, k-1) + solve(arr, k+1, j);
            
            // If this choice of k yields a better answer
            ans = Math.max(ans, res);
        }
        return dp[i][j] = ans;
    }
    
    public static int maxCoins(int N, int[] arr) {
        // code here
        
        dp = new int[N][N];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr.length; j++)
                dp[i][j] = -1;
                
        return solve(arr, 0, N-1);
    }
}
     