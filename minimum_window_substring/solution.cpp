class Solution {
public:
    string minWindow(string s, string t) {
        if(s.size() == 0 || t.size() == 0) return "";
        unordered_map<char, int> dict;
        int required = 0;
        for(int i=0; i<t.size(); i++){
            if(!dict[t[i]]){
                dict[t[i]] = 1;
                required++;
            }else{
                dict[t[i]] = dict[t[i]] + 1;
            }
        }
        int l = 0, r = 0, formed = 0;
        int ans[] = {-1, 0, 0};
        unordered_map<char, int> windowCounts;
        while(r < s.size()){
            char c = s[r];
            if(!windowCounts[c]) windowCounts[c] = 1;
            else windowCounts[c] = windowCounts[c] + 1;
            
            if(dict[c] && windowCounts[c] == dict[c]) formed++;
            while(l<=r && formed == required){
                c = s[l];
                if(ans[0] == -1 || r-l+1 < ans[0]){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts[c] = windowCounts[c] - 1;
                if(dict[c] && windowCounts[c] < dict[c]) formed--;
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substr(ans[1], ans[0]);
    }
};