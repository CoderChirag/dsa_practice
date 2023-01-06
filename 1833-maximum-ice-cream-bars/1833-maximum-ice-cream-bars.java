class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0, i = 0;
        while(i < costs.length && coins > 0){
            if(coins >= costs[i]){
                res++;
                coins -= costs[i];
            }else break;
            i++;
        }
        return res;
    }
}