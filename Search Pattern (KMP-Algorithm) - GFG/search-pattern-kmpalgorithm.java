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
                System.out.print(-1);
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
    void fillLPSArray(String s, int LPS[]){
        int n = s.length();
        LPS[0] = 0;
        int i =1, prevLPSLen = 0;
        while(i < n){
            if(s.charAt(i) == s.charAt(prevLPSLen)) LPS[i++] = ++prevLPSLen;
            else{
                if(prevLPSLen == 0) LPS[i++] = 0;
                else prevLPSLen = LPS[prevLPSLen-1];
            }
        }
    }
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> al = new ArrayList<>();
        int m = pat.length(), n = txt.length();
        int LPS[] = new int[m];
        fillLPSArray(pat, LPS);
        int i = 0, j = 0;
        while(i < n){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                al.add(i-m+1);
                j = LPS[j-1];
            }else if(i < n && txt.charAt(i) != pat.charAt(j)){
                if(j == 0) i++;
                else j = LPS[j-1];
            }
        }
        if(al.isEmpty()) al.add(-1);
        return al;
    }
}