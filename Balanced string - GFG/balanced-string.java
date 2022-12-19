//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int sumOfDigits(int N){
        int sum = 0;
        while(N > 0){
            sum += N%10;
            N /= 10;
        }
        return sum;
    }
    
    static String BalancedString(int N) {
        // code here
        int sod = sumOfDigits(N);
        String res = "";
        for(int i=0; i<N/26; i++){
            res += "abcdefghijklmnopqrstuvwxyz";
        }
        N %= 26;
        
        int count = N/2 + (N%2)*(1-sod%2);
        
        for(int i=0; i<count; i++){
            res += (char)(i+'a');
        }
        for(int i=0; i<N-count; i++){
            res += (char)((26-(N-count)+i)+'a');
        }
        
        return res;
    }
}