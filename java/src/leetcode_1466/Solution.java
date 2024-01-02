/*
 * @lc app=leetcode.cn id=1466 lang=java
 *
 * [1466] 重新规划路线
 */
package leetcode_1466;
// @lc code=start

import java.util.Arrays;

class Solution {
    // 有向路径，修改方向让所有节点都可以到达 0
    // 从0出发，让其他节点指向当前可以到达城市0的节点
    // 类似迪杰斯塔拉
    //暴力双循环
    public int minReorder(int n, int[][] connections) {
        int ans = 0;
        boolean record[] = new boolean[n];
        Arrays.fill(record, false);
        record[0] = true;
        int cur = 1;
        boolean judge = false;
        while (cur != ans||judge) {
            cur = ans;
            judge = false;
            for (int[] arr : connections) {
                if (record[arr[1]]) {
                    if(!record[arr[0]])
                        judge = true;
                    record[arr[0]] = true;
                   
                } else {
                    if (record[arr[0]]) {
                        record[arr[1]] = true;
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
    /** 优化
     * public int minReorder(int n, int[][] connections) {
        List<List<int[]>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for(int[] con: connections){
            tree.get(con[0]).add(new int[]{con[1], 1});    // con[0] 指向 con[1]，标记为1
            tree.get(con[1]).add(new int[]{con[0], 0});    // con[1] 不指向 con[0]，标记为0
        }
        boolean[] visited = new boolean[n];    
        Queue<Integer> queue = new ArrayDeque<>();         
        queue.offer(0);          
        visited[0] = true;
        int res = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();    
            for(int[] neighbor: tree.get(node)){
                if(visited[neighbor[0]])continue;    
                visited[neighbor[0]] = true;        
                queue.offer(neighbor[0]);         
                if(neighbor[1] == 1)res += 1;           
            }
        }
        return res;
    }
     */
}
// @lc code=end
