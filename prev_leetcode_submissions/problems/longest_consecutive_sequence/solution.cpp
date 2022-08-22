class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> hashSet;
        for(int num : nums){
            hashSet.insert(num);
        }
        int longestStreak = 0;
        for(int num : nums){
            if(!hashSet.count(num-1)){
                int curr = num;
                int curr_streak = 1;
                while(hashSet.count(curr+1)){
                    curr++;
                    curr_streak++;
                }
                longestStreak = max(longestStreak, curr_streak);
            }
        }
        return longestStreak;
    }
};