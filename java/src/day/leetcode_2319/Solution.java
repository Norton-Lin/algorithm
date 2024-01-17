package day.leetcode_2319;

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        for(int i = 0;i<grid.length;++i)
        {
            for(int j = 0;j<grid[i].length;++j)
            {
                if(i == j || i + j == grid.length - 1)
                {
                	if(grid[i][j] == 0)
                        return false;
                }
                else if(grid[i][j]!=0)
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int[][] gird = {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
    	boolean ans = solution.checkXMatrix(gird);
    	System.out.print(ans);
	}
}
 