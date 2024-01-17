package day.leetcode_188;

public class Solution {
    //最多买卖k次
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int res = 0;
        int buy[] = new int[k+1];
        int sell[] = new int[k+1];
        for(int j = 0;j<=k;++j)
        {
            buy[j] = -prices[0];
            sell[j] = 0;
        }
        for(int i = 0;i<n;++i)
        {
            for(int j = 1;j<=k;++j)
            {
                buy[j] = Math.max(buy[j],sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j],buy[j]+prices[i]);
                res = Math.max(res,sell[j]);
            }
        }
        return res;
    }
}
