//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static void wordBreakRec(List<String> dict, List<String> res, int n, String s, String curr){
        for(int i=1; i<=n; i++){
            String prefix = s.substring(0, i);
            if(dict.contains(prefix)){
                if(i == n){
                    curr += prefix;
                    res.add(curr);
                    return;
                }
                wordBreakRec(dict, res, n-i, s.substring(i, n), curr+prefix+" ");
            }
        }
    }
    
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        // code here
        List<String> res = new ArrayList<>();
        wordBreakRec(dict, res, s.length(), s, "");
        return res;
    }
}