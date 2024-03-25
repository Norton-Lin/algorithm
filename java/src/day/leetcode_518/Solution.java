package day.leetcode_518;
/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
                                                      
    public int change(int amount, int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        //dp[i] == dp[i-coin...]
        for(int coin:coins){
            for(int i = coin;i<=amount;++i)
                dp[i] += dp[i-coin];//i == coin 初始化为1
        }
        return dp[amount];
    }
    //dfs超时
    /**
    public int change(int amount, int[] coins) {
        int ans = 0;
        Arrays.sort(coins);
        ans = dfs(amount, coins,coins.length-1);
        return ans;
    }

    public int dfs(int amount, int[] coins, int index) {
        int ans = 0;
        for (int i = index;i>=0;--i) {
            if (coins[i] < amount)
                ans += dfs(amount - coins[i], coins,i);
            else if (coins[i] == amount)
                ans += 1;

        }
        return ans;
    }*/
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.change(5, new int[]{1,2,5}));
    }
}
// @lc code=end
