class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int sign = 1, i = 0;
        int res = 0;
        if(s.charAt(0) == '-'){
            sign = -1;
            i = 1;
        }else if(s.charAt(0) == '+'){
            i = 1;
        }
        for(; i < s.length(); i++){
            int num = s.charAt(i) - '0';
            if(num >= 0 && num <= 9){
                if(sign > 0){
                    if(res <= Integer.MAX_VALUE/10 && (res*10) < Integer.MAX_VALUE-num)
                        res = res*10 + num;
                    else return Integer.MAX_VALUE;
                }else{
                    if(res*sign >= Integer.MIN_VALUE/10 && (res*10)*sign > Integer.MIN_VALUE+num ) res = res*10 + num;
                    else return Integer.MIN_VALUE;
                }
                
            }else break;
        }
        return res*sign;
    }
}