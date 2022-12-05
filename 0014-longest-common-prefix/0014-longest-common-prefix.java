class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0) return "";
        int minLen = Integer.MAX_VALUE; 
        for(int i=0; i<n; i++){
            if(strs[i].length() < minLen) minLen = strs[i].length();
        }
        String res = "";
        for(int i=0; i<minLen; i++){
            for(int j=1; j<n; j++){
                if(strs[j].charAt(i) != strs[j-1].charAt(i)) return res; 
            }
            res += strs[0].charAt(i);
        }
        return res;
    }
}