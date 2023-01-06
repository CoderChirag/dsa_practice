//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku.
    
    static boolean isSafe(int grid[][], int i, int j, int n){
        for(int k=0; k<9; k++){
            if(grid[i][k] == n || grid[k][j] == n) return false;
        }
        
            
        int rs = i - i%3;
        int cs = j - j%3;
        for(int k=0; k<3; k++){
            for(int l=0; l<3; l++){
                if(grid[k+rs][l+cs] == n) return false;
            }
        }
        return true;
    }
    
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        int i=-1, j=-1;
        for(int ii=0; ii<9; ii++){
            for(int jj=0; jj<9; jj++){
                if(grid[ii][jj] == 0){
                    i = ii;
                    j = jj;
                    break;
                }
            }
        }
                
        if(i == -1 || j == -1) return true;
        
        for(int n=1; n<=9; n++){
            if(isSafe(grid, i, j, n)){
                grid[i][j] = n;
                if(SolveSudoku(grid)) return true;
                grid[i][j] = 0;
            }
        }
        return false;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}