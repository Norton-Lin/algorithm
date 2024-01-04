/*
 * @lc app=leetcode.cn id=2397 lang=java
 *
 * [2397] 被列覆盖的最多行数
 */
package leetcode_2397;

// @lc code=start



class Solution {
    //二进制枚举
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;//矩阵行
        int n = matrix[0].length;//矩阵列
        int[] mask = new int[m];//记录矩阵行的1数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                mask[i] += matrix[i][j] << (n - j - 1);//二进制记录矩阵1位置，矩阵转二进制数
            }
        }
        int res = 0;
        int cur = 0;//所有覆盖的可能
        int limit = (1 << n);
        while (++cur < limit) {
            if (Integer.bitCount(cur) != numSelect) {
                continue;
            }//选中行数不足
            int t = 0;
            for (int j = 0; j < m; j++) {
                if ((mask[j] & cur) == mask[j]) {
                    ++t;
                }//该行的1被覆盖
            }
            res = Math.max(res, t);
        }
        return res;
    }
}

// @lc code=end

