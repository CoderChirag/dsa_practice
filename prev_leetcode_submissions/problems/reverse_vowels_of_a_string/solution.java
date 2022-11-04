class Solution {
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    
    public String reverseVowels(String s) {
        char[] res = s.toCharArray();
        int low = 0, high = res.length-1;
        while(low < res.length && !isVowel(res[low])) low++;
        while(high >= 0 && !isVowel(res[high])) high--;
        while(low < high){
            char temp = res[low];
            res[low] = res[high];
            res[high] = temp;
            low++;
            high--;
            while(low < res.length && !isVowel(res[low])) low++;
            while(high >= 0 && !isVowel(res[high])) high--;
        }
        return String.valueOf(res);
    }
}