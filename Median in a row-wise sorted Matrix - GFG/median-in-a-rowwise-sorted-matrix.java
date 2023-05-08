//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here  
        int low = 0, high = 1_000_000_000;
        int N = R*C;
        while(low <= high){
            int cnt = 0;
            int mid = low + (high-low)/2;
            for(int i=0; i<R; i++){
                int l = 0, r = C-1;
                while(l <= r){
                    int m = l+(r-l)/2;
                    if(matrix[i][m] <= mid && (m == C-1 || matrix[i][m+1] > mid)){
                        cnt += m+1;
                        break;
                    }else if(matrix[i][m] <= mid) l = m+1;
                    else r = m-1;
                }
            }
            // if(cnt == N/2) return mid+1;
            if(cnt <= N/2) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}