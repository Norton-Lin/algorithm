/*
 * @lc app=leetcode.cn id=2003 lang=java
 *
 * [2003] 每棵子树内缺失的最小基因值
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    //若子树节点没有1，最小基因值必定为1
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);//构建树
        }

        Set<Integer> geneSet = new HashSet<Integer>();
        boolean[] visited = new boolean[n];

        int[] res = new int[n];
        Arrays.fill(res, 1);
        int iNode = 1, node = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) //找基因值为1的节点的子节点
            {
                node = i;
                break;
            }
        }
        while (node != -1) //还没遍历到根
        {
            dfs(node, nums, children, geneSet, visited);
            while (geneSet.contains(iNode)) {
                iNode++;
            }//动态更新基因值
            res[node] = iNode;//获取基因值
            node = parents[node];
        }
        return res;
    }

    public void dfs(int node, int[] nums, List<Integer>[] children, Set<Integer> geneSet, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        geneSet.add(nums[node]);
        for (int child : children[node]) {
            dfs(child, nums, children, geneSet, visited);
        }
    }
}
// @lc code=end

