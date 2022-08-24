class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minCP = prices[0], profit = 0;
        for(int i=1; i<prices.size(); i++){
            if(prices[i] > minCP){
                profit += prices[i] - minCP;
                minCP = prices[i];
            }
            minCP = min(minCP, prices[i]);
        }
        return profit;
    }
};