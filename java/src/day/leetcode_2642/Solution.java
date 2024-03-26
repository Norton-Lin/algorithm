package day.leetcode_2642;
/*
 * @lc app=leetcode.cn id=2642 lang=java
 *
 * [2642] 设计可以求最短路径的图类
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
// @lc code=start
class Graph {
    // 构建邻接矩阵
    int[][] map;
    public Graph(int n, int[][] edges) {
        map = new int[n][n];
        for (int[] edge : edges) {
            map[edge[0]][edge[1]] = edge[2];
        }
        
    }

    // 加一条边
    public void addEdge(int[] edge) {
        map[edge[0]][edge[1]] = edge[2];
    }
    //暴力迪杰斯塔拉
    public int shortestPath(int node1, int node2) {
        int[] len = new int[map.length];//结点最短路径
        Set<Integer> set = new HashSet<>();
        Arrays.fill(len, 100000000);
        len[node1] = 0;
        set.add(node1);
        int next = 0;
        int cur = Integer.MAX_VALUE;
        int size = 1;
        while(true){
            next = -1;
            cur = Integer.MAX_VALUE;
            for(int i = 0;i<len.length;++i){
                if(set.contains(i))
                    continue;
                for(int j:set){
                    if(map[j][i]==0)
                        continue;
                    len[i] = Math.min(len[i],len[j] + map[j][i]);
                    if(cur>len[i]){
                        cur = len[i];//当前最小
                        next = i;
                    }
                } 
            }
            if(next != -1){
                set.add(next);
            }
            if(size == set.size()||next == node2)
                break;
            ++size;
        }
        
        return set.contains(node2)?len[node2]:-1;
    }
    /**迪杰斯塔拉 优先队列+邻接表优化           
     * private List<int[]>[] graph;

    public Graph(int n, int[][] edges) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<int[]>();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int cost = edge[2];
            graph[x].add(new int[]{y, cost});
        }
    }

    public void addEdge(int[] edge) {
        int x = edge[0];
        int y = edge[1];
        int cost = edge[2];
        graph[x].add(new int[]{y, cost}); 
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        pq.offer(new int[]{0, node1});
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int cost = arr[0], cur = arr[1];
            if (cur == node2) {
                return cost;
            }
            for (int[] nextArr : graph[cur]) {
                int next = nextArr[0], ncost = nextArr[1];
                if (dist[next] > cost + ncost) {
                    dist[next] = cost + ncost;
                    pq.offer(new int[]{cost + ncost, next});
                }
            }
        }
        return -1;
    }
     */
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
// @lc code=end
