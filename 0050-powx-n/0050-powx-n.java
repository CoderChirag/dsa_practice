class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long nn = n;
        boolean neg = nn < 0 ? true : false;
        nn = nn < 0 ? -nn : nn;
        while(nn > 0){
            if((nn & 1) != 0){
                res *= x;
            }
            x *= x;
            nn >>= 1;
        }
        return neg ? 1.0/res : res;
    }
}