//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static boolean isSafe(int board[][], int n, int row, int col){
        for(int j=0; j<col; j++){
            if(board[row][j] == 1) return false;
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 1) return false;
        }
        for(int i=row, j=col; i<n && j>=0; i++, j--){
            if(board[i][j] == 1) return false;
        }
        return true;
    }
    
    static void nQueenRec(int[][] board, int n, int col, ArrayList<ArrayList<Integer>> res){
        
        if(col == n){
            ArrayList<Integer> al = new ArrayList<>();
            for(int j=0; j<n; j++){
                for(int i=0; i<n; i++){
                    if(board[i][j] == 1){
                        al.add(i+1);
                    }
                }
            }
            res.add(al);
            return;
        };
        
        for(int i=0; i<n; i++){
            if(isSafe(board, n, i, col)){
                board[i][col] = 1;
                nQueenRec(board, n, col+1, res);
                board[i][col] = 0;
            }
        }
    }
    
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int board[][] = new int[n][n];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        nQueenRec(board, n, 0, res);
        return res;
    }
}