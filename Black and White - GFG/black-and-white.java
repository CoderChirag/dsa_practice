//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    private static long MOD = 1000000007;
    // static boolean isValidPos(int N, int M, int x, int y){
    //     return (x >= 0 && x < N && y >= 0 && y < M);
    // }
    
    // static long numOfWays(int N, int M)
    // {
    //     // add your code here
    //     long res = 0;
    //     int dx[] = {1, -1, 1, -1, 2, -2, 2, -2};
    //     int dy[] = {2, 2, -2, -2, 1, 1, -1, -1};
        
    //     for(int x=0; x<N; x++){
    //         for(int y=0; y<M; y++){
    //             int cnt = 0;
    //             for(int i=0; i<8; i++){
    //                 if(isValidPos(N, M, x+dx[i], y+dy[i])) cnt++;
    //             }
    //             res = (res%MOD + (((N*M)%MOD-1)-cnt)%MOD)%MOD;
    //         }
    //     }
    //     return res;
    // }
    
    static long numOfWays(int N, int M){
        if(N == 1 && M == 1) return 0;
        else if(N == 1) return (M*(M-1)%MOD);
        else if(M == 1) return (N*(N-1)%MOD);
        
        long nm = (N*M)%MOD;
        long totalPossibleArrangements = (nm*(nm-1))%MOD;
        long h2v1 = 4*((N-1)*(M-2))%MOD;
        long h1v2 = 4*((N-2)*(M-1))%MOD;
        return totalPossibleArrangements - h2v1 - h1v2;
    }
}