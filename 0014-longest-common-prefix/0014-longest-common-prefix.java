class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int start = 0, end = prefix.length();
        for(int i=0; i<strs.length; i++){
            int l = 0;
            while(l < strs[i].length() && l < end && strs[i].charAt(l) == prefix.charAt(l)) l++;
            end = l;
        }
        return prefix.substring(start, end);
    }
}