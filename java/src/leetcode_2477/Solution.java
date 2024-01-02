/*
 * @lc app=leetcode.cn id=2477 lang=java
 *
 * [2477] 到达首都的最少油耗
 */
package leetcode_2477;
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    //尽可能凑一辆车
    //无向图
    //构建一颗n叉树，然后一层一层往上带，当前几辆车，已经消耗多少油
    long ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        
        List<Integer> tree[] = new List[roads.length+1];
        for(int i = 0;i<tree.length;++i){
            tree[i] = new ArrayList<>();
        }
        for(int[] road:roads){
            tree[road[0]].add(road[1]);
            tree[road[1]].add(road[0]);
        }
        dfs(0, -1, seats, tree);
        return ans;
    }

    public int dfs(int cur, int fa, int seats, List<Integer>[] g) {
        int peopleSum = 1;
        for (int ne : g[cur]) {
            if (ne != fa) {
                int peopleCnt = dfs(ne, cur, seats, g);
                peopleSum += peopleCnt;
                ans += (peopleCnt + seats - 1) / seats;
            }
        }
        return peopleSum;
    }
}
// @lc code=end

