//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int k) {
        // code here
       int n = str.length();
       ArrayDeque<Character> st = new ArrayDeque<>();
       for(int i=0; i<n; i++){
           while(!st.isEmpty() && st.peek() > str.charAt(i) && k != 0){
               st.pop();
               k--;
           }
           st.push(str.charAt(i));
       }
       
       StringBuilder res = new StringBuilder();
       while(!st.isEmpty()){
           char c = st.pop();
           if(k != 0){
               k--;
               continue;
           }
           res.append(Character.toString(c));
       }
       
       res.reverse();
       for(int i=0; i<res.length(); i++){
           if(res.charAt(i) != '0') return res.substring(i);
       }
       
       return "0";
        
    }
}