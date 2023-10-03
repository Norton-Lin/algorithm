package leetcode_121;

class Solution {
    // 1. O(n^2) 暴力循环
    // 2. O(n) 动态规划
    /**
    public int maxProfit(int[] prices) {
        int[] dp_max = new int[prices.length];
        int[] dp_min = new int[prices.length];
        dp_min[0] = prices[0];
        dp_max[prices.length-1] = prices[prices.length-1];
        
        for(int i = 1;i<prices.length;++i){
            dp_min[i] = Math.min(prices[i], dp_min[i-1]);
        }
        int res = Math.max(dp_max[prices.length-1] - dp_min[prices.length-1],0);
        for(int i = prices.length-2;i>=0;--i){
            dp_max[i] = Math.max(prices[i], dp_max[i+1]);
            res = Math.max(dp_max[i] - dp_min[i],res);
        }
        return 0;
    }*/
    // 利润 = 卖出 - 买入
    public int maxProfit(int[] prices){
        int res = 0;
        for(int i = 0;i<prices.length;++i){
            res = res<prices[i] - prices[0] ? prices[i] - prices[0] : res;
            prices[0] = prices[0]>prices[i] ? prices[i] : prices[0];
        }
        return res;
    }
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        Solution s = new Solution();
        System.out.println(s.maxProfit(prices));
    }
}
