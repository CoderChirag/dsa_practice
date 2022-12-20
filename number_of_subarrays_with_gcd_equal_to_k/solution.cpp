class Solution {
public:
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    
    int subarrayGCD(vector<int>& nums, int k) {
        int cnt = 0, prevGCD;
        for(int i=0; i<nums.size(); i++){
            prevGCD = nums[i];
            for(int j=i; j<nums.size(); j++){
                prevGCD = gcd(prevGCD, nums[j]);
                if(prevGCD == k) cnt++;
                else if(prevGCD < k) break;
            }
        }
        return cnt;
    }
};