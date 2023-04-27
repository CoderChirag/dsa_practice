//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xor = 0;
        for(int i=0; i<n; i++){
            xor ^= arr[i];
            xor ^= (i+1);
        }
        int rightmost_set_bit = xor & ~(xor-1);
        int l_bucket = 0, r_bucket = 0;
        for(int i=0; i<n; i++){
            if((rightmost_set_bit & arr[i]) != 0){
                l_bucket ^= arr[i];
            }else {
                r_bucket ^= arr[i];
            }
            if((rightmost_set_bit & (i+1)) != 0){
                l_bucket ^= (i+1);
            }else{
                r_bucket ^= (i+1);
            }
        }
        for(int i=0; i<n; i++){
            if(l_bucket == arr[i]) return new int[]{l_bucket, r_bucket};
            else if(r_bucket == arr[i]) return new int[]{r_bucket, l_bucket};
        }
        return new int[]{l_bucket, r_bucket};
    }
}