class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, end = 0;
        for(int i=0; i<n; i++){
            int l = i, r = i;
            while(l >= 0  && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            int len = r-l-1;
            l = i;
            r = i+1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            len = Math.max(len, r-l-1);
            if(len > end-start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
}