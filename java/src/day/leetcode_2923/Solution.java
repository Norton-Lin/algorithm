package day.leetcode_2923;
/*
 * @lc app=leetcode.cn id=2923 lang=java
 *
 * [2923] 找到冠军 I
 */

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
// @lc code=start
class Solution {
    // 对grid[i][j] i!=j if grid[i][j] == 1 i强 否则 j强
    // 找最强
    // 1 全遍历
    // 2 只找更强\
    /**
    public int findChampion(int[][] grid) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int index = -1;
        queue.add(0);
        set.add(0);
        while(!queue.isEmpty()){
            index = queue.poll();
            boolean judge = true;
            set.remove(index);
            for(int i = 0;i<grid.length;++i){
                if(i != index){
                    if(grid[index][i] == 0){
                        if(!set.contains(i)){
                            queue.add(i);
                        set.add(i);
                        }
                        judge = false;
                    }   
                }
            }
            if(judge)
                break;
        }
        return index;
    }*/
    //全遍历反而更快
    public int findChampion(int[][] grid){
        int index = 0;
        int n = grid.length;
        int cur = 1;
        while(index<n && cur == 1){
            cur = 1;
            for(int i = 0;i<n&&cur == 1;++i){
                if(index == 1)
                    continue;
                cur&=grid[index][i];
            }
        }
        return index;
    }
}
// @lc code=end
