class Solution {
    public String intToRoman(int num) {
        int decimal[] = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String roman[] = new String[]{"I","IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String res = "";
        for(int i=12; i>=0; i--){
            while(num >= decimal[i]){
                res = res + roman[i];
                num -= decimal[i];
            }
        }
        return res;
    }
}