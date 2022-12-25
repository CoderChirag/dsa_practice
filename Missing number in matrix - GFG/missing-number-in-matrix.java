//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long  MissingNo(int[][] matrix)
    {
        int n = matrix.length;
        int zi = 0, zj = 0;
        long[] rowSum = new long[n], colSum = new long[n];
        long diagSum1 = 0, diagSum2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += matrix[i][j];
                colSum[j] += matrix[i][j];
                if(i == j)
                    diagSum1 += matrix[i][j];
                if(j == n-i-1)
                    diagSum2 += matrix[i][j];
                if(matrix[i][j] == 0) {
                    zi = i;
                    zj = j;
                }
            }
        }
        int k = 0;
        while (k == zi) k++;
        long ans = rowSum[k] - rowSum[zi];
        if(ans <= 0) return -1;

        rowSum[zi] += ans;
        colSum[zj] += ans;
        for (int i = 0; i < n; i++) {
            if(rowSum[i] != rowSum[k] || colSum[i] != rowSum[k])
                return -1;
        }

        if(zi == zj) diagSum1 +=  ans;
        if(zi == n-zj-1) diagSum2 += ans;
        if(diagSum1 != rowSum[k] || diagSum2 != rowSum[k]) 
            return -1;

        return ans;
    }
}