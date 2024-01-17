package day.leetcode_1039;

import java.util.Arrays;

class Solution {
    private int[] v;
    private int[][] memo;
    //dp 点i - j 的多边形的最小值
    public int minScoreTriangulation(int[] values) {
        v = values;
        int n = v.length;
        memo = new int[n][n];//0 - n 划分
        for (int i = 0; i < n; ++i)
            Arrays.fill(memo[i], -1); // -1 表示没有访问过
        return dfs(0, n - 1);
    }
    //i-j的多边形最低分
    private int dfs(int i, int j) {
        if (i + 1 == j) return 0; // 只有两个点，无法组成三角形
        if (memo[i][j] != -1) return memo[i][j];//访问过
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) // 枚举顶点 k
            res = Math.min(res, dfs(i, k) + dfs(k, j) + v[i] * v[j] * v[k]);
        return memo[i][j] = res;
    }
}