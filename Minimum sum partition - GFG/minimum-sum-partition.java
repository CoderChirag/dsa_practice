//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int total_sum;

    public int rec(int i, int curr_sum, int arr[], int dp[][]){
        if(i == 0){
            return Math.abs((total_sum - curr_sum) - curr_sum);
        }
        if(dp[i-1][curr_sum] != -1) return dp[i-1][curr_sum];
        int res = Math.min(rec(i-1, curr_sum, arr, dp), rec(i-1, curr_sum+arr[i-1], arr, dp));
        dp[i-1][curr_sum] = res;
        return res;
    }

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    total_sum = 0;
	    for(int ele : arr) total_sum += ele;
	    int dp[][] = new int[n][total_sum+1];
	    for(int row[] : dp) Arrays.fill(row, -1);
	    return rec(n, 0, arr, dp);
	} 
}
