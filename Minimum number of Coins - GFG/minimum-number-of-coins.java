//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int NOTES[] = new int[]{2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(N > 0 && i < NOTES.length){
            if(N/NOTES[i] > 0){
                for(int j=0; j<N/NOTES[i]; j++){
                    res.add(NOTES[i]);
                }
                N %= NOTES[i];
            }
            i++;
        }
        return res;
    }
}