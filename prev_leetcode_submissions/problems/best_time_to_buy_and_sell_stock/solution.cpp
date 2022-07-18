class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n < 2) return 0;
        int profit = prices[1] - prices[0], minVal = prices[0];
        for(int i=1; i<n; i++){
            profit = max(profit, prices[i]-minVal);
            minVal = min(minVal, prices[i]);
        }
        return profit > 0 ? profit : 0;
    }
};