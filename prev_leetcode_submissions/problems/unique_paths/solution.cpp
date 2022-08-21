class Solution {
public:
    double fact(int n){
        double res = 1;
        for(int i=2; i<=n; i++){
            res *= i;
        }
        return res;
    }
    int uniquePaths(int m, int n) {
        // int N = n+m-2;
        // int r = m-1;
        // return (int)(fact(N)/(fact(r)*fact(N-r)));
        int N = n + m - 2;
            int r = m - 1; 
            double res = 1;
            
            for (int i = 1; i <= r; i++)
                res = res * (N - r + i) / i;
            return (int)res;
    }
};