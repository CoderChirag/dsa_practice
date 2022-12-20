class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0;
        unordered_map<char, int> hash;
        int i=0, j=0, curr_len = 0;
        while(j < s.size()){
            if(!hash[s[j]]){
                hash[s[j]] = 1;
                curr_len++;
                res = max(res, curr_len);
                j++;
            }else{
                while(s[i] != s[j]){
                    hash[s[i]] = 0;
                    i++;
                    curr_len--;
                }
                i++;
                hash[s[j]] = 1;
                j++;
            }
        }
        return res;
    }
};