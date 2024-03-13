/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
package hot100.leetcode_200;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    //广度优先搜索
    //dfs会更快（）
    public int numIslands(char[][] grid) {
        boolean[][] record = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0;i<grid.length;++i){
            for(int j = 0;j<grid[0].length;++j){
                if(record[i][j])
                    continue;
                record[i][j] = true;
                if(grid[i][j] == '1'){
                    bfs(grid, record,i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid, boolean[][] record, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            i = cur[0];
            j = cur[1];
            if(i>0){
                if(!record[i-1][j]){
                    record[i-1][j] = true;
                    if(grid[i-1][j] == '1')
                        queue.add(new int[]{i-1,j});
                }
            }
            if(i<grid.length-1){
                if(!record[i+1][j]){
                    record[i+1][j] = true;
                    if(grid[i+1][j] == '1')
                        queue.add(new int[]{i+1,j});
                }
            }
            if(j>0){
                if(!record[i][j-1]){
                    record[i][j-1] = true;
                    if(grid[i][j-1] == '1')
                        queue.add(new int[]{i,j-1});
                }
            }
            if(j<grid[0].length-1){
                if(!record[i][j+1]){
                    record[i][j+1] = true;
                    if(grid[i][j+1] == '1')
                        queue.add(new int[]{i,j+1});
                }
            }
        }

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.numIslands(new char[][]{{'1','1'}});
        /**
        s.numIslands(new char[][]{{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}});*/
    }
}
// @lc code=end

