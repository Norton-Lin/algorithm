/*
 * @lc app=leetcode.cn id=1901 lang=java
 *
 * [1901] 寻找峰值 II
 */
package leetcode_1901;
// @lc code=start
class Solution {
    //寻找峰值升级版
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = -1, maxElement = -1;
            //找当前行最大值
            for (int k = 0; k < n; k++) {
                if (mat[i][k] > maxElement) {
                    j = k;
                    maxElement = mat[i][k];
                }
            }
            //查看是否符合条件
            if (i - 1 >= 0 && mat[i][j] < mat[i - 1][j]) {
                high = i - 1;
                continue;
            }
            if (i + 1 < m && mat[i][j] < mat[i + 1][j]) {
                low = i + 1;
                continue;
            }
            return new int[]{i, j};
        }
        return new int[0]; // impossible
    }
}
// @lc code=end
