class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int LPS[] = new int[2*n+1];
        LPS[0] = 0;
        int maxLen = 1, maxIndex = 0;
        for(int i=1; i<2*n+1; i++){
            int len = i%2 != 0 ? 1 : 0;
            int left = (i/2)-1, right = i%2 != 0 ? (i/2)+1 : i/2;
            while(left >=0 && right < n && s.charAt(left) == s.charAt(right)){
                len += 2;
                left--;
                right++;
            }
            LPS[i] = len;
            if(len > maxLen){
                maxLen = len;
                maxIndex = (i-len)/2;
            }
        }
        String res = "";
        for(int i=0; i<maxLen; i++){
            res += s.charAt(i+maxIndex);
        }
        return res;
    }
}