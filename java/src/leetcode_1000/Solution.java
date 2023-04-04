package leetcode_1000;

import java.util.Arrays;

class Solution {
    static final int INF = 0x3f3f3f3f;
    /**
    定义dp[i][j]为尽可能多的合并区间[i, j] 所需的成本，不一定能合并成一堆，但合并完成后剩下的堆数一定小于k，
    更具体地，剩余的堆数一定是(n - 1) % (k - 1) + 1。
证明：
    已知一次合并会导致堆数减少k-1，假设最多进行了a次合并，则有
        remain = n - (k - 1) * a，1 <= remain <= k - 1，
        remain - 1 = n - 1 - (k - 1) * a
        remain - 1 = (n - 1) % (k - 1)
        remain = (n - 1) % (k - 1) + 1
            证毕。

        我们参照解法一来定义状态转移方程，同样将区间[i，j]划分为两部分。
        我们保证将左部分合并成1堆，而尽可能多地合并右部分。（左部分需要满足(len - 1) % (k - 1) == 0）。
        右部分剩余堆数满足1 <= remain <= k - 1，如果最后右部分剩余k-1堆（也即(j - i) % (k - 1) == 0），则还可以继续将这两部分合并成1堆。
        因此合并区间[i，j]的成本是合并其左右部分成本之和（对于最优的划分）。如果可以进一步合并的话，则额外的成本是sum(i, j)。
        状态转移方程为：dp[i][j] = min(dp[i][p] + dp[p + 1][j]), i <= p < j，如果可以继续合并，dp[i][j] += sum(i, j)。

        这样的话枚举的区间长度就必须从k开始了，因为长度在[1，k-1]之间的区间已经无法进行合并了，它们的dp[i][j] == 0。
     */
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        //必定无解
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
        }
        int[] sum = new int[n];//前缀和
        for (int i = 0, s = 0; i < n; i++) {
            d[i][i] = 0;//一堆石子合并不需要花费
            s += stones[i];//前缀合
            sum[i] = s;
        }

        for (int len = 2; len <= n; len++) {//枚举区间长度
            for (int l = 0; l < n && l + len - 1 < n; l++) {//枚举区间终点
                int r = l + len - 1;
                for (int p = l; p < r; p += k - 1) {//枚举分界点
                    d[l][r] = Math.min(d[l][r], d[l][p] + d[p + 1][r]);
                }
                if ((r - l) % (k - 1) == 0) {
                    d[l][r] += sum[r] - (l == 0 ? 0 : sum[l - 1]);
                }
            }
        }
        return d[0][n - 1];
    }
}