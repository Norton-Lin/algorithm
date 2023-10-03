package leetcode_122;

class Solution {
    //买卖多支股票，同时最多持有一只
    //贪心，高抛低吸
    //可以在同一天买卖同一支股票
    public int maxProfit(int[] prices) {
        int res = 0;
        int cur = prices[0];
        for(int i = 0;i<prices.length;++i)
        {
            if(cur<=prices[i])//当前价高于买入价
            {
                res += prices[i] - cur; //卖出，获得利润
            }
            cur = prices[i];
        }
        return res;
    }
}
