//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            if(res.size()==0)
                System.out.print("-1 ");
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void fillZArray(String s, int Z[]){
        int n = s.length();
        Z[0] = 0;
        int l = 0, r = 0;
        for(int i=1; i<n; i++){
            if(i > r){
                l = r = i;
                while(r < n && s.charAt(r-l) == s.charAt(r)) r++;
                Z[i] = r-l;
                r--;
            }else{
                int k = i-l;
                if(Z[k] < r-i+1){
                    Z[i] = Z[k];
                }else{
                    l = i;
                    while(r < n && s.charAt(r-l) == s.charAt(r)) r++;
                    Z[i] = r-l;
                    r--;
                }
            }
        }
    }
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here
        ArrayList<Integer> al = new ArrayList<>();
        String s = pat + "_" + S;
        int Z[] = new int[s.length()];
        fillZArray(s, Z);
        for(int i=0; i<s.length(); i++){
            if(Z[i] == pat.length()) al.add(i-pat.length());
        }
        if(al.isEmpty()) al.add(-1);
        return al;
    }
}