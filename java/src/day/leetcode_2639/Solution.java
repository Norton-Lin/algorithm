package day.leetcode_2639;
/*
 * @lc app=leetcode.cn id=2639 lang=java
 *
 * [2639] 查询网格图中每一列的宽度
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] ans = new int[col];
        Arrays.fill(ans,0);
        int cur = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                cur = String.valueOf(i).length();
                //cur = Integer.toString(grid[i][j]).length();
                if(cur>ans[j])
                    ans[j] = cur;
                //ans[j] = Math.max(ans[j],cur);
            }
        }
        return ans;
    }
}
// @lc code=end
