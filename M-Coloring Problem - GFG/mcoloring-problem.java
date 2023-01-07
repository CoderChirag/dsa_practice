//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    
    public boolean isSafe(boolean graph[][], int colors[], int n, int v, int color){
        for(int k=0; k<graph[v].length; k++){
            if(graph[v][k] && colors[k] == color) return false;
        }
        return true;
    }
    
    public boolean solveRec(boolean graph[][], int colors[], int m, int n, int v){
        if(v == n) return true;
    
        
        for(int color=1; color<=m; color++){
            if(isSafe(graph, colors, n, v, color)){
                colors[v] = color;
                if(solveRec(graph, colors,  m, n, v+1)) return true;
                colors[v] = -1;
            }
        }
        return false;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int colors[] = new int[n];
        Arrays.fill(colors, -1);
        return solveRec(graph, colors, m, n, 0);
    }
}