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
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String s)
    {
        // your code here
        int q = 101, d = 256;
        ArrayList<Integer> al = new ArrayList<>();
        int n = s.length(), m = pat.length();
        int h = 1;
        for(int i=1; i<m; i++) h = (h*d)%q; // d^(m-1)
        
        int p = 0, t = 0;
        for(int i=0; i<m; i++){
            p = (p*d + pat.charAt(i))%q;
            t = (t*d + s.charAt(i))%q;
        }
        for(int i=0; i<n-m+1; i++){
            if(p == t){
                boolean flag = true;
                for(int j=0; j<m; j++){
                    if(s.charAt(i+j) != pat.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag) al.add(i+1);
            }
            if(i < n-m){
                t = (d*(t - s.charAt(i)*h) + s.charAt(i+m))%q;
                if(t < 0) t += q;
            }
        }
        if(al.isEmpty()) al.add(-1);
        return al;
    }
}