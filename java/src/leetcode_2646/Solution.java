/*
 * @lc app=leetcode.cn id=2646 lang=java
 *
 * [2646] 最小化旅行的价格总和
 */
package leetcode_2646;

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        List<Integer>[] next = new List[n];
        for (int i = 0; i < n; i++) {
            next[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            next[edge[0]].add(edge[1]);
            next[edge[1]].add(edge[0]);
        }

        int[] count = new int[n];
        for (int[] trip : trips) {
            dfs(trip[0], -1, trip[1], next, count);
        }

        int[] pair = dp(0, -1, price, next, count);
        return Math.min(pair[0], pair[1]);
    }

    public boolean dfs(int node, int parent, int end, List<Integer>[] next, int[] count) {
        if (node == end) {
            count[node]++;
            return true;
        }
        for (int child : next[node]) {
            if (child == parent) {
                continue;
            }
            if (dfs(child, node, end, next, count)) {
                count[node]++;
                return true;
            }
        }
        return false;
    }

    public int[] dp(int node, int parent, int[] price, List<Integer>[] next, int[] count) {
        int[] res = {price[node] * count[node], price[node] * count[node] / 2};
        for (int child : next[node]) {
            if (child == parent) {
                continue;
            }
            int[] pair = dp(child, node, price, next, count);
            res[0] += Math.min(pair[0], pair[1]); // node 没有减半，因此可以取子树的两种情况的最小值
            res[1] += pair[0]; // node 减半，只能取子树没有减半的情况
        }
        return res;
    }
}

// @lc code=end

