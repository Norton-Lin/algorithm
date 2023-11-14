/*
 * @lc app=leetcode.cn id=1334 lang=java
 *
 * [1334] 阈值距离内邻居最少的城市
 */

// @lc code=start
package leetcode_1334;
import java.util.Arrays;

class Solution {
    //城市数量小于等于100
    //弗洛伊德暴力 O(n^3)
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        int ans = 0;
        int cur = 0,record = Integer.MAX_VALUE;
        for(int i = 0;i<n;++i)
            Arrays.fill(dis[i], 10000);
        for(int i = 0;i<edges.length;++i){
            dis[edges[i][0]][edges[i][1]] = edges[i][2];
            dis[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(int i = 0;i<n;++i){
            dis[i][i] = 0;
            for(int j = 0;j<n;++j){
                for(int k = 0;k<n;++k){
                    cur = dis[i][k]+dis[k][j];
                    if(cur<dis[i][j])
                        dis[i][j] = dis[j][i]= cur;
                }
            }
        }
        for(int i = 0;i<n;++i){
            cur = 0;
            for(int j = 0;j<n;++j){
                if(dis[i][j]<=distanceThreshold)
                    ++cur;
            }
            if(cur<=record)
            {
                ans = i;
                record = cur;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int ans = s.findTheCity(4, new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4);
        System.out.println(ans);
    }
}
// @lc code=end

