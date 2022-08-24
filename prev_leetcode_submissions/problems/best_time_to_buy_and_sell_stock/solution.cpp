class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n < 2) return 0;
        int minCP = prices[0], profit = prices[1] - prices[0];
        for(int i=1; i<n; i++){
            profit = max(profit, prices[i]-minCP);
            minCP = min(minCP, prices[i]);
        }
        return profit < 0 ? 0 : profit;
    }
};