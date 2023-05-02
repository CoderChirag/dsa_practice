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
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int nums[], int n) {
        // code here
        int l = 0, r = n-1, min =Integer.MAX_VALUE, min_ind = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] >= nums[l]){
                if(nums[l] < min){
                    min = nums[l];
                    min_ind = l;
                }
                l = mid + 1;
            }else{
                if(nums[mid] < min){
                    min = nums[mid];
                    min_ind = mid;
                }
                r = mid-1;
            }
        }
        return min_ind;
    }
}