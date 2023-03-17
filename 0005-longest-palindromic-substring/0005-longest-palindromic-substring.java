class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, end = 0;
        for(int i=0; i<n; i++){
//             Starting by taking current index as center 
            int left = i, right = i;
            while(left >=0 && right<n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
//             Starting by taking next index as center
            int len = right - left - 1;
            left = i;
            right = i+1;
            while(left >=0 && right < n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            len = Math.max(len, right-left-1);
            if(len > end-start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
}