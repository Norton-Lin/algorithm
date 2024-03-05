package day.leetcode_1976;
/*
 * @lc app=leetcode.cn id=1976 lang=java
 *
 * [1976] 到达目的地的方案数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    //花费最少时间到达目的地的路径数
    //迪杰斯特拉算法
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000000 + 7;
        List<int[]>[] edge = new List[n];
        for(int i = 0;i<n;++i){
            edge[i] = new ArrayList<>();
        }
        for(int[] road: roads){
            int x = road[0], y =road[1], z = road[2];
            edge[x].add(new int[]{y,z});
            edge[y].add(new int[]{x,z});
        }//构建邻接表
        long dis[] = new long[n];//记录0到节点的最短距离
        Arrays.fill(dis,Long.MAX_VALUE);
        int[] ways = new int[n];//记录0到节点最短距离的路径数
        //优先队列,路径长度和点编号
        PriorityQueue<long[]> queue = new PriorityQueue<long[]>((a,b)->Long.compare(a[0], b[0]));
        queue.offer(new long[]{0,0});
        dis[0] = 0;
        ways[0] = 1;
        while(!queue.isEmpty()){
            long[] arr = queue.poll();
            long t = arr[0];
            int u = (int)arr[1];
            if(t>dis[u])//距离大于最短距离
                continue;
            for(int[] next : edge[u]){
                int v = next[0],w = next[1];
                if(t+w<dis[v]){
                    dis[v] = t + w;//更新最短距离
                    ways[v] = ways[u];
                    queue.offer(new long[]{t+w,v});
                }else if (t + w == dis[v])
                    ways[v] = (ways[v]+ways[u])%mod;
            }
        }
        return ways[n-1];
    }
}
// @lc code=end

