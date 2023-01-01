class Solution {
    public int countDigits(int num) {
        int cnt = 0, n = num;
        while(n > 0){
            if(num%(n%10) == 0) cnt++;
            n /= 10;
        }
        return cnt;
    }
}