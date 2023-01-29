class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int res = 1;
        while(r < s.length()){
            if(!set.contains(s.charAt(r))){
                res = Math.max(res, r-l+1);
            }else{
                while(l < r && s.charAt(l) != s.charAt(r)){
                    set.remove(s.charAt(l));
                    l++;
                };
                if(l != r) l++;
            }
            set.add(s.charAt(r));
            r++;
        }
        return res;
    }
}