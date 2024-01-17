package day.leetcode_2698;
/*
 * @lc app=leetcode.cn id=2698 lang=java
 *
 * [2698] 求一个整数的惩罚数
 */

// @lc code=start
class Solution {
    static int[] f = new int[1010];
    static {
        for (int i = 1; i <= 1000; i++) {
            f[i] = f[i - 1];
            if (check(i * i, i)) f[i] += i * i;
        }
    }
    static boolean check(int t, int x) {
        if (t == x) return true;
        int d = 10;
        while (t >= d && t % d <= x) {
            if (check(t / d, x - (t % d))) return true;
            d *= 10;
        }
        return false;
    }
    public int punishmentNumber(int n) {
        return f[n];
    }
}
// @lc code=end

