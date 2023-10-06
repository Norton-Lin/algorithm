package leetcode_714;

class Solution {
    //dp[i][0] 当前没有股票
    //dp[i][1] 当前有股票
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[3];
        dp[0] = dp[2]= 0 ;
        dp[1] = 0-fee-prices[0];
        for(int i =1;i<prices.length;++i)
        {
            dp[2] = dp[0];
            dp[0] = Math.max(dp[0],dp[1]+prices[i]);
            dp[1] = Math.max(dp[2]-fee-prices[i],dp[1]);
        }
        return Math.max(dp[0],dp[1]);
    }
}