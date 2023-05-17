//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int k = sc.nextInt();
      Solution obj = new Solution();
      double ans = obj.findSmallestMaxDist(a,k);
      System.out.printf("%.2f",ans);
      System.out.println();
    }
  }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
  public static boolean isPossible(int stations[], double maxDist, int K){
      for(int i=1; i<stations.length; i++){
          if(stations[i]-stations[i-1] > maxDist){
              K -= (int)((stations[i]-stations[i-1])/maxDist);
          }
      }
      return K >= 0 ? true : false;
  }    
    
  public static double findSmallestMaxDist(int stations[],int K) {
    // code here
    double l = 0, r = 1e9;
    double eps = 1e-5;
    double res = -1;
    for(int i=1; i<stations.length; i++){
        l = Math.min(l, stations[i]-stations[i-1]);
    }
    while((r-l) > eps){
        double mid = (l+r)/2.0;
        if(isPossible(stations, mid, K)){
            res = mid;
            r = mid;
        }else l = mid;
    }
    return res;
  }
}
     