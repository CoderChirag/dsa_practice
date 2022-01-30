class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size() == 1)
            return 0;
        int profit = 0;
        int c_p = prices[0], s_p = prices[1];
        for(int i=1; i<prices.size(); i++){
            profit = max(s_p - c_p, profit);
            if(i != prices.size()-1){
                c_p = min(c_p, prices[i]);
            }
            if(c_p != prices[i]){
                s_p = max(s_p, prices[i]);
            }else if(i != prices.size()-1){
                s_p = prices[i+1];
            }
        }
        profit = max(s_p - c_p, profit);
        return profit;
    }
};