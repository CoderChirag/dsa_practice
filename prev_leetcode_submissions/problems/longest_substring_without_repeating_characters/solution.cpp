class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.length() == 0) return 0;
        vector<int> arr(256, -1);
        int left = 0, right = 0, ans = 0;
        while(right < s.size()){
            if(arr[s[right]] != -1)
                left = max(arr[s[right]]+1, left);
            arr[s[right]] = right;
            ans = max(ans, right-left+1);
            right++;
        }
        return ans;
    }
};