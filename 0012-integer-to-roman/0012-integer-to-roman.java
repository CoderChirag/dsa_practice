class Solution {
//     O(logn) TIme & O(1) Space
    // public String intToRoman(int num) {
    //     int decimal[] = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    //     String roman[] = new String[]{"I","IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    //     String res = "";
    //     for(int i=12; i>=0; i--){
    //         while(num >= decimal[i]){
    //             res = res + roman[i];
    //             num -= decimal[i];
    //         }
    //     }
    //     return res;
    // }
    
//     O(1) Time & O(1) Space
    public String intToRoman(int num) {
        String ones[] = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tens[] = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hundreds[] = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String thousands[] = new String[]{"", "M", "MM", "MMM"};    // Since N <= 3999
        
        return thousands[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + ones[(num%10)];
    }
}