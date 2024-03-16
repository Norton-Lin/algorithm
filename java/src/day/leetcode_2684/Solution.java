/*
 * @lc app=leetcode.cn id=2684 lang=java
 *
 * [2684] 矩阵中移动的最大次数
 */
import java.util.Arrays;

// @lc code=start
class Solution {
    /**
    public int maxMoves(int[][] grid) {
        int ans = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = 0;
        for(int i = 0;i<dp.length;++i){
            for(int j = 0;j<dp[i].length;++j){
                if(j>0&&grid[i][j]>grid[i][j-1])
                    dp[i][j] = dp[i][j] > dp[i][j-1] + 1?dp[i][j]:dp[i][j-1] + 1;
                if(i<dp.length-1&&j>0&&grid[i][j]>grid[i+1][j-1])
                    dp[i][j] = dp[i][j] > dp[i+1][j-1] + 1?dp[i][j]:dp[i+1][j-1] + 1;
                if(i>0&&j>0&&grid[i][j]>grid[i-1][j-1])
                    dp[i][j] = dp[i][j] > dp[i-1][j-1] + 1?dp[i][j]:dp[i-1][j-1] + 1;
                ans = ans > dp[i][j] ? ans:dp[i][j];
            }
        }
        return ans;
    }
     */
    //优化，深搜
    private int ans;

    public int maxMoves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, grid); // 从第一列的任一单元格出发
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] grid) {
        ans = Math.max(ans, j);
        if (ans == grid[0].length - 1) { // ans 已达到最大值
            return;
        }
        // 向右上/右/右下走一步
        for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, grid.length); k++) {
            if (grid[k][j + 1] > grid[i][j]) {
                dfs(k, j + 1, grid);
            }
        }
        grid[i][j] = 0;//剪枝
    }
}
// @lc code=end
