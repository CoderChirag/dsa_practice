//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int rec(int ind, int prev_ind, int n, int arr[], int dp[][]){
        if(ind == n){
            return 0;
        }
        if(dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind+1];
        int not_take = 0 + rec(ind + 1, prev_ind, n, arr, dp);
        int take = 0;
        if(prev_ind == -1 || arr[prev_ind] < arr[ind]){
            take = 1 + rec(ind+1, ind, n, arr, dp);
        }
        return dp[ind][prev_ind + 1] = Math.max(not_take, take);
    }
    static int longestSubsequence(int size, int a[])
    {
        // code here
        int dp[][] = new int[size+1][size];
        for(int row[] : dp) Arrays.fill(row, -1);
        return rec(0, -1, size, a, dp);
    }
} 