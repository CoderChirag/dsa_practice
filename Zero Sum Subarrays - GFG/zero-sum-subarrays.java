//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

// Naive Approach - O(n^2) Time Limit Exceeded  
// class Solution{
//     //Function to count subarrays with sum equal to 0.
//     public static long findSubarray(long[] arr ,int n) 
//     {
//         //Your code here
//         long res = 0;
//         for(int i=0; i<n; i++){
//             long sum = 0;
//             for(int j=i; j<n; j++){
//                 sum += arr[j];
//                 if(sum == 0) res++;
//             }
//         }
//         return res;
//     }
// }

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long, Integer> freq = new HashMap<>();
        long sum = 0, res = 0;
        freq.put(0L, 1);
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(freq.containsKey(sum)) freq.put(sum, freq.get(sum)+1);
            else freq.put(sum, 1);
            res += freq.get(sum)-1;
        }
        return res;
    }
}