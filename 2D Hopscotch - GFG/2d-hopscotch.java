//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            String a1[] = in.readLine().trim().split("\\s+");
            int ty = Integer.parseInt(a1[0]);
            int i = Integer.parseInt(a1[1]);
            int j = Integer.parseInt(a1[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.hopscotch(n, m, mat, ty, i, j));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j) 
    {
        // code here
        ArrayList<Integer> dx, dy;
        if(ty == 0){
            if(j%2 == 0){
                dx = new ArrayList<>(Arrays.asList(-1, 1, 0, 0, -1, -1));
                dy = new ArrayList<>(Arrays.asList(0, 0, 1, -1, -1, 1));
            }else{
                dx = new ArrayList<>(Arrays.asList(-1, 1, 0, 0, 1, 1));
                dy = new ArrayList<>(Arrays.asList(0, 0, 1, -1, -1, 1));
            }
        }else{
            if(j%2 == 0){
                dx = new ArrayList<>(Arrays.asList(-2, 2, 0, 0, -1, -1, 1, 1, 1, 1, -2, -2));
                dy = new ArrayList<>(Arrays.asList(0, 0, -2, 2, -2, 2, -2, 2, -1, 1, -1, 1));
            }else{
                dx = new ArrayList<>(Arrays.asList(-2, 2, 0, 0, -1, -1, 1, 1, -1, -1, 2, 2));
                dy = new ArrayList<>(Arrays.asList(0, 0, -2, 2, -2, 2, -2, 2, -1, 1, -1, 1));
            }
        }
        int res = 0;
        for(int k=0; k<dx.size(); k++){
            int x = i + dx.get(k), y = j + dy.get(k); 
            if(x < n && x >=0 && y < m && y >= 0) res += mat[x][y];
        }
        return res;
    }
}