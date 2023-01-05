//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix

// Time Complexity: O(4^(N^2)) As we are making 4 calls from each of the N^2 cells of matrix
// class Solution {
//     public static void findPathRec(int[][] m, int n, int i, int j, ArrayList<String> res, String curr){
//         if(i<0 || i>=n || j<0 || j>=n || m[i][j] == 0) return;
//         if(i == n-1 && j == n-1){
//             res.add(curr);
//             return;
//         }
        
//         m[i][j] = 0;
//         findPathRec(m, n, i-1, j, res, curr+"U");
//         findPathRec(m, n, i, j+1, res, curr+"R");
//         findPathRec(m, n, i, j-1, res, curr+"L");
//         findPathRec(m, n, i+1, j, res, curr+"D");
//         m[i][j] = 1;
//     }
    
//     public static ArrayList<String> findPath(int[][] m, int n) {
//         // Your code here
//         ArrayList<String> res = new ArrayList<>();
//         findPathRec(m, n, 0, 0, res, "");
//         return res;
//     }
// }

// Time Complexity: O(3^(N^2)) As there are N^2 cells and from each cell there are 3 unvisited neighbouring cells
// (Because, one of the cell is already visited every time)
class Solution {
    // Traverse in order Down->Left->Right->Up (so as to get the sorted paths)
    static int dx[] = new int[]{1, 0, 0, -1};
    static int dy[] = new int[]{0, -1, 1, 0};
    static String key[] = new String[]{"D", "L", "R", "U" };
    
    public static boolean isSafe(int[][] m, int n, int i, int j){
        return (i>=0 && i<n && j>=0 && j<n && m[i][j] == 1);
    }
    
    public static void findPathRec(int[][] m, int n, int i, int j, ArrayList<String> res, String curr){
        if(i == n-1 && j == n-1){
            res.add(curr);
            return;
        };
        m[i][j] = 0;
        for(int k=0; k<4; k++){
            int x = i + dx[k], y = j + dy[k];
            if(isSafe(m, n, x, y)) findPathRec(m, n, x, y, res, curr+key[k]);
        }
        m[i][j] = 1;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        if(m[0][0] == 1){
            findPathRec(m, n, 0, 0, res, "");
        }
        return res;
    }
}