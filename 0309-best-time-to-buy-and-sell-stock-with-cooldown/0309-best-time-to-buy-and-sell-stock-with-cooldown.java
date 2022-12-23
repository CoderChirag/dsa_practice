class Solution {
    public int solve(int i,int buy,int[] price,int[][] dp)
   {
     if(i>=price.length) return 0;
     if(dp[i][buy]!=-1) return dp[i][buy];
     int profit =0;
     if(buy==0){ //means we have to buy now
       profit =Math.max(0+solve(i+1,0,price,dp),-price[i]+solve(i+1,1,price,dp));
     }
     if(buy==1){ //means it's time to sell now 
       profit =Math.max(0+solve(i+1,1,price,dp),price[i]+solve(i+2,0,price,dp));
     }
     
     return dp[i][buy]=profit;
     
   }
   public int maxProfit(int[] price) {
     int n=price.length;
     int[][] dp=new int[n][2];
     for(int d[]:dp){
            Arrays.fill(d,-1);
        }
      return solve(0,0,price,dp);
    }
}