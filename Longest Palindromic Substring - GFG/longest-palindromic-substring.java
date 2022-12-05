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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String S){
        // code here
        int n = S.length();
        int LPS[] = new int[2*n+1];
        LPS[0] = 0;
        int maxLen = 1, maxIndex = 0;
        for(int i=1; i<2*n+1; i++){
            int len = i%2 != 0 ? 1 : 0;
            int left = (i/2)-1, right = i%2 != 0 ? (i/2)+1 : i/2;
            while(left >=0 && right < n && S.charAt(left) == S.charAt(right)){
                len += 2;
                left--;
                right++;
            }
            LPS[i] = len;
            if(len > maxLen){
                maxLen = len;
                maxIndex = (i-len)/2;
            }
        }
        
        String res = "";
        for(int i=0; i<maxLen; i++){
            res += S.charAt(i+maxIndex);
        }
        return res;
    }
}