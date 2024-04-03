/*
 * @lc app=leetcode.cn id=2312 lang=java
 *
 * [2312] 卖木头块
 */

// @lc code=start
class Solution {
    //dp（i,j) 木块大小为 i ,j 所能得到的钱数
    //当大小是 木块大小，dp[i][j] = price / 
    //dp[i][j] = price[2] + dp[i-price[k][0]][j-price[k][1]]
    //
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m+1][n+1];
        for(int[] price:prices){
            dp[price[0]][price[1]]= price[2];
        }
        for(int i = 1;i<m;++i){
            for(int j = 1;j<n;++j){
                dfs(i,j,dp);
            }
        }
        return dp[m][n];
    }
    public void dfs(int i, int j, int[][] dp){
        
    }
}
// @lc code=end

