class Solution {
//     O(2*N) Time & O(N) Space
    // public int lengthOfLongestSubstring(String s) {
    //     int n = s.length(), res = 1;
    //     if(n == 0) return 0;
    //     HashSet<Character> set = new HashSet<>();
    //     int l = 0, r = 0;
    //     while(r < n){
    //         char ch = s.charAt(r);
    //         if(set.contains(ch)){
    //             while(l <r && s.charAt(l) != ch) set.remove(s.charAt(l++));
    //             l++;
    //         }
    //         set.add(ch);
    //         res = Math.max(res, set.size());
    //         r++;
    //     }
    //     return res;
    // }
    
//     O(N) Time & O(N) Space
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int l = 0, r = 0, max_len = 0;
        int map[] = new int[256];
        Arrays.fill(map, -1);
        
        while(r < s.length()){
            int ch = s.charAt(r);
            if(map[ch] != -1) l = Math.max(map[ch] + 1, l);
            map[ch] = r;
            max_len = Math.max(max_len, r-l+1);
            r++;
        }
        return max_len;
    }
}