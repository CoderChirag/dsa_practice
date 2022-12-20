class Solution {
public:
    double myPow(double x, int n) {
        double res = 1.0;
        bool flag = true;
        if(n < 0 ){
            flag = false;
            n = abs(n);
        };
        while(n > 0){
            if(n & 1){
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        if(!flag) res = 1/res;
        return res;
    }
};