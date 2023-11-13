/*
 * @lc app=leetcode.cn id=2300 lang=java
 *
 * [2300] 咒语和药水的成功对数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    //potions药水
    //O(n^2)超时
    //降O(nlogn)
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        int[][] idx = new int[n][2];
        for (int i = 0; i < n; ++i) {
            idx[i][0] = spells[i];
            idx[i][1] = i;
        }
        Arrays.sort(potions);
        for (int i = 0, j = m - 1; i < j; ++i, --j) {
            int temp = potions[i];
            potions[i] = potions[j];
            potions[j] = temp;
        }
        Arrays.sort(idx, (a, b) -> a[0] - b[0]);
        for (int i = 0, j = 0; i < n; ++i) {
            int p = idx[i][1];
            int v = idx[i][0];
            while (j < m && (long) potions[j] * v >= success) {
                ++j;
            }
            res[p] = j;
        }
        return res;
    }                                                          
}
// @lc code=end

