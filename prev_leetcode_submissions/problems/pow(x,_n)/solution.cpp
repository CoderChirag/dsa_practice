class Solution {
public:
   double myPow(double x, int n) {
        
        double ans = 1.0;
        long long nn = n;
        
        if(n < 0) nn = nn * -1;
        
        while(nn){
            if(nn % 2){
                nn = nn - 1;
                ans = ans * x;
            }else{
                nn = nn / 2;
                x = x * x;
            }
        }
        if(n<0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }
};