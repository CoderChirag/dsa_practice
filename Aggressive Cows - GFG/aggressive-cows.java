//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean isCompatible(int[] stalls, int dist, int cows){
        int n = stalls.length;
        int k = stalls[0];
        cows--;
        for(int i=1; i<n; i++){
            if(stalls[i] - k >= dist){
                cows--;
                if(cows == 0) return true;
                k = stalls[i];
            }
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
         int l = 1, r = stalls[n-1] - stalls[0];
         int res = -1;
         while(l <= r){
             int mid = (l+r)/2;
             if(isCompatible(stalls, mid, k)){
                res = mid;
                l = mid+1;
             }else r = mid-1;
         }
         return res;
    }
}