package day.leetcode_309;
class Solution {
    //卖出股票后，无法在第二天买入股票，必须隔一天才能买入股票
    //卖出操作和买入操作不能连续进行
    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        int dp[][] = new int[n][3];
        dp[0][0] = - prices[0];
        dp[0][1] = dp[0][2] = 0;
        for(int i = 1;i<n;++i)
        {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
            res = Math.max(res,dp[i][1]);
        }
        return res;
    }
}
