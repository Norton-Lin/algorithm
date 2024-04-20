package day.leetcode_1883;
/*
 * @lc app=leetcode.cn id=1883 lang=java
 *
 * [1883] 准时抵达会议现场的最小跳过休息次数
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    // 休息，指必须停留到整数时间
    // 看，都休息的话要多久，减去那些休息的时间？
    // 那如果合出来一个更长的休息时间怎么办
    // 其实就是筛选那几个最高效的休息时间
    // 先算都不休息，然后选幸运时间向上取整
    // 记录每条路的最晚开始时间
    // 速度放慢speed倍，就没有分数
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        int ans = -1;
        hoursBefore *= speed;
        int[][] dp = new int[n + 1][n + 1];// 过i个路径，休息i次的最大时间
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i != j) {
                    int tmp = dp[i - 1][j] + dist[i - 1];
                    if (tmp % speed != 0)
                        tmp = (tmp / speed + 1) * speed;
                    dp[i][j] = Math.min(dp[i][j], tmp);
                }
                if (j != 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dist[i - 1]);
                }
            }
        }

        for (int i = 0; i <= n; ++i) {
            if (dp[n][i] <= hoursBefore) {
                ans = i;
                break;
            }

        }

        return ans;
    }
}
// @lc code=end
