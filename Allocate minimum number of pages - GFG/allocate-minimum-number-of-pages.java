//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    
    public static boolean isPossible(int[] A, int pages, int students){
        int sumAllocated = 0;
        for(int i=0; i<A.length; i++){
            if(sumAllocated + A[i] > pages){
                students--;
                sumAllocated = A[i];
                if(sumAllocated > pages) return false;
            }else{
                sumAllocated += A[i];
            }
        }
        return students > 0 ? true : false;
    }
    
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(M > N) return -1;
        int l = A[0], r = 0;
        for(int i=0; i<N; i++){
            l = Math.min(l, A[i]);
            r += A[i];
        }
        int res = -1;
        while(l <=r){
            int mid = (l+r)/2;
            if(isPossible(A, mid, M)){
                res = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return res;
    }
};







