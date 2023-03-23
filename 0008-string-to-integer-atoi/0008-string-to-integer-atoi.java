class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        long ans = 0;
        for(int i=0; i<s.length(); i++){
            if(i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) continue;
            else if(s.charAt(i) < '0' || s.charAt(i) > '9') break;
            else{
                if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) break;
                ans = (ans*10) + (int)(s.charAt(i) - '0');
            }
        }
        
        if(s.charAt(0) == '-') ans = -ans;
        
        if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
            return ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return (int)ans;
    }
}