//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int max_count = 0, res = -1;
        for(int i=0; i<n; i++){
            int l = 0, r = m-1, pos = -1;
            while(l <= r){
                int mid = (l+r)/2;
                if((mid == 0 || (arr[i][mid-1] == 0)) && arr[i][mid] == 1){
                    pos = mid;
                    break;
                }else if(arr[i][mid] == 0) l = mid+1;
                else r = mid-1;
            }
            int count = pos != -1 ? (m - pos) : 0;
            if(count > max_count){
                max_count = count;
                res = i;
            }
        }
        return res;
    }
}