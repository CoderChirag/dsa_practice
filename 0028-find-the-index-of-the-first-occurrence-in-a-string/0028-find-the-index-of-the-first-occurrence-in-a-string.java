class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int prev = -1;
        for(int i=0; i<n; i++){
            int j = 0;
            if(haystack.charAt(i+j) == needle.charAt(j)){
                prev = i;
                while(i+j < n && j < m && haystack.charAt(i+j) == needle.charAt(j) ) j++;
                if(j == m) return prev;
                else{
                    prev = -1;
                }
            }
        }
        return prev;
    }
}