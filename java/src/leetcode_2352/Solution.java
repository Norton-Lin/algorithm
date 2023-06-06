package leetcode_2352;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
	/**
	 * 查看行和列是否相同
	 * 矩阵行列长度最大为200
	 * 特殊情况 [[11,1],[1,11]] 需要分隔符
	 * 哈希
	 * @param grid
	 * @return
	 */
	/**
    public int equalPairs(int[][] grid) {
    	int ans = 0;
    	HashMap<String, Integer> map = new HashMap<>();
    	for(int i = 0;i<grid[0].length;++i) {
    		StringBuilder stringBuilder = new StringBuilder();
    		for(int j = 0;j<grid.length;++j) {
    			stringBuilder.append(grid[j][i]);
                stringBuilder.append(" ");
    		}
    		String s = stringBuilder.toString();
    		map.put(s, map.getOrDefault(s, 0)+1);
    	}
    	for(int[] row:grid) {
    		StringBuilder stringBuilder = new StringBuilder();
    		for(int i:row) {
    			stringBuilder.append(i);
                stringBuilder.append(" ");
    		}
    		ans += map.getOrDefault(stringBuilder.toString(), 0);
    	}
    	return ans;
    }*/
	//Arrays直接行比较
	public int equalPairs(int[][] grid) {
		int ans = 0;
		int[][] compare = new int[grid[0].length][grid.length];
		for(int i = 0;i<grid[0].length;++i) {
    		for(int j = 0;j<grid.length;++j) {
    			compare[i][j] = grid[j][i];
    		}
    	}
		for(int i = 0;i<grid.length;++i)
		{
			for(int j = 0;j<compare.length;++j)
			{
				if(Arrays.equals(grid[i], compare[j]))
					++ans;
			}
		}
		return ans;
	}
}