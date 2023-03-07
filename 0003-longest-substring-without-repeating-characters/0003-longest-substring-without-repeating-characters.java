class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 1;
        if(n == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        while(r < n){
            char ch = s.charAt(r);
            if(set.contains(ch)){
                while(l <r && s.charAt(l) != ch) set.remove(s.charAt(l++));
                l++;
            }
            set.add(ch);
            res = Math.max(res, set.size());
            r++;
        }
        return res;
    }
}