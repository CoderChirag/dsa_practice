typedef long long ll;
class Solution {
public:
    ll kadane(vector<int>& arr){
        ll res = 0, maxFinding = 0;
        for(ll i=0; i<arr.size(); i++){
            maxFinding = max(maxFinding+arr[i], (ll)arr[i]);
            res = max(res, maxFinding);
        }
        return res;
    }
    
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        if(arr.size() == 0) return 0;
        
        const int mod = 1e9+7;
        
        ll kadane_sum = kadane(arr);
        if(k == 1) return kadane_sum%mod;
        
        ll curr_prefix_sum = 0, curr_suffix_sum = 0;
        ll max_prefix_sum = INT_MIN, max_suffix_sum = INT_MIN;
        for(ll i=0; i<arr.size(); i++){
            curr_prefix_sum = (curr_prefix_sum + arr[i]);
            max_prefix_sum = max(max_prefix_sum, curr_prefix_sum);
        }
        ll total_sum = curr_prefix_sum;
        for(ll i=arr.size()-1; i>=0; i--){
            curr_suffix_sum = (curr_suffix_sum + arr[i]);
            max_suffix_sum = max(max_suffix_sum, curr_suffix_sum);
        }
        ll res = 0;
        if(total_sum < 0){
            res = max((max_prefix_sum+max_suffix_sum), kadane_sum);
        }else{
            ll prod = total_sum*(k-2);
            res = max((max_prefix_sum+max_suffix_sum+prod), kadane_sum);
        }
        return res%mod;
    }
};