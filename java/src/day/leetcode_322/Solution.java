package day.leetcode_322;
/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

import java.util.Arrays;
import java.util.Comparator;

// @lc code=start
class Solution {
    //01背包
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        boolean[] record = new boolean[amount+1];
        Arrays.fill(dp,amount);
        dp[0] = 0;
        record[0] =  true;
        for(int i = 0;i<dp.length;++i){
            if(record[i]){
                for(int coin:coins){
                    if((long)i+(long)coin<dp.length){
                        dp[i+coin] = Math.min(dp[i]+1,dp[i+coin]);
                        record[i+coin] = true;
                    }
                }
            }
            
        }
        return record[amount]?dp[amount]:-1;
    }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.coinChange(new int[]{1,2,5}, 11);
    }
    //超时
    /**
    public void dfs(int[] coins, int amount, int cur){
        if(amount == 0)
            ans = cur;
        if(ans <= cur || amount<0)
            return ;
        for(int coin: coins){
            dfs(coins, amount - coin, cur + 1);
        }
    }*/
}
// @lc code=end

