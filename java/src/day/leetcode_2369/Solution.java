package day.leetcode_2369;
/*
 * @lc app=leetcode.cn id=2369 lang=java
 *
 * [2369] 检查数组是否存在有效划分
 */

// @lc code=start
class Solution {
    // dp 前n-2 n-3是否存在有效划分
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; ++i) {
            if (i >= 2) {
                dp[i] = dp[i - 2] && checkTwo(nums[i - 1], nums[i - 2]);
            }
            if (i >= 3) {
                dp[i] = dp[i] || dp[i - 3] && checkThree(nums[i - 1], nums[i - 2], nums[i - 3]);
            }
        }
        return dp[nums.length];
    }

    public boolean checkTwo(int a, int b) {
        return a == b;
    }

    public boolean checkThree(int a, int b, int c) {
        return (a == b && b == c) || (a == b + 1 && b == c + 1);
    }
    /** 优化
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            if (f[i - 1] && nums[i] == nums[i - 1] ||
                i > 1 && f[i - 2] && (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                                      nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)) {
                f[i + 1] = true;
            }
        }
        return f[n];
    }*/
}
// @lc code=end
