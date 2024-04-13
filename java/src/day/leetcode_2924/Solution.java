package day.leetcode_2924;
/*
 * @lc app=leetcode.cn id=2924 lang=java
 *
 * [2924] 找到冠军 II
 */

// @lc code=start
class Solution {
    //计算入度就好
    public int findChampion(int n, int[][] edges) {
        int ans = -1;
        boolean[] record = new boolean[n];
        for(int[] edge: edges)
            record[edge[1]] = true;
        for(int i = 0;i<n;++i){
            if(!record[i]){
                if(ans == -1)
                    ans = i;
                else{
                    ans = -1;
                    break;
                }
                    
            }
        }
        return ans;
    }
}
// @lc code=end

