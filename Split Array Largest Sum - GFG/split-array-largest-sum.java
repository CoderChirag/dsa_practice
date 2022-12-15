//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int mi = -1, ma = 0;
        for(int i=0; i<N; i++){
            mi = Math.max(mi, arr[i]);
            ma += arr[i];
        }
        int ans = 0;
        
        while(mi <= ma){
            int mid = (mi + ma)/2;
            int subarray = 0, su = 0;
            for(int i=0; i<N; i++){
                su += arr[i];
                if(su > mid){
                    subarray++;
                    su = arr[i];
                }
            }
            if(subarray + 1 <= K){
                ans = mid;
                ma = mid-1;
            }else mi = mid + 1;
        }
        return ans;
        
    }
};