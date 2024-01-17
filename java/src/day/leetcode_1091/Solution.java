package day.leetcode_1091;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	//bfs
	static int[][] move = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;
    	Integer[] cur;//本次点位数
    	int next_row,next_col;
    	int[][] count = new int[row][col];
    	for(int i =0;i<row;++i)
    		Arrays.fill(count[i], -1);
    	Queue<Integer[]> queue = new LinkedList<>();
        if(grid[0][0]!=0)
            return -1;
    	queue.add(new Integer[] {0,0});
    	count[0][0] = 1;
    	while(!queue.isEmpty())
    	{
    		cur = queue.poll();
    		if(cur[0]==row-1&&cur[1]==col-1)
    			break;
    		else {
    			for(int[] item:move)
    			{
    				next_row = item[0]+cur[0];
    				next_col = item[1]+cur[1];
                    if(next_row<0||next_col<0||next_row>=row||next_col>=col||grid[next_row][next_col]!=0)
                        continue;
    				if(count[next_row][next_col]!=-1)
    					continue;
    				else
    				{
    					count[next_row][next_col] = count[cur[0]][cur[1]]+1;
    					queue.add(new Integer[] {next_row,next_col});
    				}
    			}
    		}
    	}
    	return count[row-1][col-1];
    }
    /**
     * 时空间优化，没事别tm用Integer
     public int shortestPathBinaryMatrix(int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;
    	int[] cur;//本次点位数
    	int next_row,next_col;
    	Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0]!=0||grid[row-1][col-1]!=0)
            return -1;
    	queue.add(new int[] {0,0});
    	grid[0][0] = 1;
    	while(!queue.isEmpty())
    	{
    		cur = queue.poll();
    		if(cur[0]==row-1&&cur[1]==col-1)
    			break;
    		else {
    			for(int[] item:move)
    			{
    				next_row = item[0]+cur[0];
    				next_col = item[1]+cur[1];
                    if(next_row>=0&&next_col>=0&&next_row<row&&next_col<col&&grid[next_row][next_col]==0)
                    {
    					grid[next_row][next_col] = grid[cur[0]][cur[1]]+1;
    					queue.add(new int[] {next_row,next_col});
    				}
    			}
    		}
    	}
    	return grid[row-1][col-1]>0?grid[row-1][col-1]:-1;
    }
     */
}