package day.leetcode_1690;
/*
 * @lc app=leetcode.cn id=1690 lang=java
 *
 * [1690] 石子游戏 VII
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    //移除左右石头，获得剩余石头分数之和
    //要获取最高分，尽量自己移除低分，对方移除高分
    //i,j 
    //alice移除i，获得sum - stones[i]
    //bob移除i+1获得sum-stones[i] - stones[i+1]
    //或移除j 获得sum-stones[i] - stones[j]
    //alice无论如何都会得到更高的分数，这个分数源自bob移除的石子
    //alice要设法让bob每次移除的石头总和最大
    //bob要设法让自己每次移除的石头总和最小
    //问题转换成，alice移除stone总值最小
    //dp i - j范围内的最大分差
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] += s[i] + stones[i];
        }
        int[] f = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[j] = Math.max(s[j + 1] - s[i + 1] - f[j], s[j] - s[i] - f[j - 1]);
            }
        }
        return f[n - 1];
    }
}
// @lc code=end

