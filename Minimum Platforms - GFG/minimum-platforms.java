//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


// O(N*log(n)) Time Complexity & O(N) Space Complexity
class Pair implements Comparable<Pair>{
    int time;
    char c;
    Pair(int time, char c){
        this.time = time;
        this.c = c;
    }
    
    @Override
    public int compareTo(Pair p){
        if(time == p.time) return Character.compare(c, p.c);
        return Integer.compare(time, p.time);
    }
}

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        ArrayList<Pair> al = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            al.add(new Pair(arr[i], 'a'));
            al.add(new Pair(dep[i], 'd'));
        }
        
        Collections.sort(al);
        
        int res = 1, plat_needed = 0;
        for(int i=0; i<al.size(); i++){
            Pair p = al.get(i);
            
            if(p.c == 'a') plat_needed++;
            else plat_needed--;
            
            res = Math.max(res, plat_needed);
        }
        return res;
    }
    
}

