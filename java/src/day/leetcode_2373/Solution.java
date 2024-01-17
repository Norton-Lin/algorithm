package day.leetcode_2373;

class Solution {
	//每个小矩阵检查一遍。。。
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid.length-2];
        for(int i =0;i<ans.length;++i)
        {
            for(int j =0;j<ans[0].length;++j)
            {
                int max = 0;
                for (int i1=i ; i1 < i+3; i1++) {
                    for (int j1 = j; j1 < j + 3 ; j1++) {
                        max = Math.max(max,grid[i1][j1]);
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;
    }
}
/*
 *尝试dp.jpg
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid.length-2];
        int[][] dp = new int[grid.length-2][grid.length];
        for(int i =0;i<grid.length-2;++i)
        {
            for(int j =0;j<grid[i].length;++j)
                dp[i][j] = Math.max(Math.max(grid[i][j],grid[i+1][j]),grid[i+2][j]);
        }
        for(int i =0;i<ans.length;++i)
        {
            for(int j =0;j<ans[0].length;++j)
                ans[i][j] = Math.max(Math.max(dp[i][j],dp[i][j+1]),dp[i][j+2]);
        }
        return ans;
    }
}
 * */
