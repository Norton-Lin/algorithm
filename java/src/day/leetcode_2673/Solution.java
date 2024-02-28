package day.leetcode_2673;
/*
 * @lc app=leetcode.cn id=2673 lang=java
 *
 * [2673] 使二叉树所有路径值相等的最小代价
 */

// @lc code=start
class Solution {
    // 满二叉树 非叶结点必有两个子结点
    // 让根到每个叶子结点的路径值相等
    // 自底向上 各个叶子结点到祖先节点的路径值都要相等
    // cost[i] 表示cost i+1号节点的值
    // 子节点是 2i 和 2i+1
    int ans = 0;

    public int minIncrements(int n, int[] cost) {
        int value = dfs(n, 1, cost, 0);
        return ans;
    }

    // 以root为根，到该结点要加的值
    // 不能贪心
    // 自底向上根据路径求
    public int dfs(int n, int root, int[] cost, int pre) {
        if (2 * root > n)// 是子结点
            return pre + cost[root - 1];
        int left = dfs(n, 2 * root, cost, cost[root - 1] + pre);
        int right = dfs(n, 2 * root + 1, cost, cost[root - 1] + pre);
        ans += Math.abs(left - right);
        return Math.max(left, right);
    }
    /** 优化
    public int minIncrements(int n, int[] cost) {
        int res = 0;
        for (int i = n / 2; i > 0; i--) {
            res += Math.abs(cost[2 * i - 1] - cost[2 * i]);
            cost[i - 1] += Math.max(cost[2 * i - 1], cost[2 * i]);
        }
        return res;
    }*/
}
// @lc code=end
