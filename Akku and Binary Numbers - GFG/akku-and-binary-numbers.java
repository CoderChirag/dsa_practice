//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        Solution ob = new Solution();
        ob.precompute();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long R = Long.parseLong(input_line[1]);
            long ans = ob.solve(L, R);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// O((R-L)log(R)) Solution - Time Limit Exceeded
// class Solution{
    
//     void precompute(){
//         // Code Here
//     }
//     long solve(long L, long R){
//         // Code here
//         int res = 0;
//         for(long i=L; i<=R; i++){
//             Long j = i;
//             int set_bits = 0;
//             while(j > 0){
//                 j = j&(j-1);
//                 set_bits++;
//             }
//             if(set_bits == 3) res++;
//         }
//         return res;
//     }
    
// }

// Time Complexity - O(63^3) (As 2^63 > 10^18) = O(1)
class Solution{
    
    void precompute(){
        // Code Here
    }
    long solve(long L, long R){
        // Code here
        int res = 0;
        for(long i=1; i<=R; i*=2){
            for(long j=i*2; j<=R; j*=2){
                for(long k=j*2; k<=R; k*=2){
                    long n = i|j|k;
                    if(n >=L && n <=R) res++;
                }
            }
        }
        return res;
    }
    
}
