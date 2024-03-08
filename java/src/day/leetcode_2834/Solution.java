package day.leetcode_2834;
/*
 * @lc app=leetcode.cn id=2834 lang=java
 *
 * [2834] 找出美丽数组的最小和
 */

// @lc code=start
class Solution {
    public int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % MOD);
        }
        return (int) (((long) (1 + m) * m / 2 + 
                ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }
}
// @lc code=end

