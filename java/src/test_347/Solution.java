package test_347;

import java.util.HashSet;

public class Solution {
	//消除后续0
	public String removeTrailingZeros(String num) {
		int len = num.length()-1;
		while(len>=0)
		{
			if(num.charAt(len)!='0')
				break;
			--len;
		}
		return num.substring(0,len+1);
    }
	//计算矩阵对角线不同值数量的差
	public int[][] differenceOfDistinctValues(int[][] grid) {
		int[][] ans = new int[grid.length][grid[0].length];
		int value = 0;
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0;i<grid.length;++i)
		{
			for(int j = 0;j<grid[i].length;++j)
			{
				int k = 1;
				set.clear();
				while(i-k>=0&&j-k>=0)
				{
					set.add(grid[i-k][j-k]);
					++k;
				}
				value = set.size();
				k = 1;
				set.clear();
				while(i+k<grid.length&&j+k<grid[i].length)
				{
					set.add(grid[i+k][j+k]);
					++k;
				}
				ans[i][j] = Math.abs(value-set.size());
			}
		}
		return ans;
    }
	//翻转0-i / i-n-1的字符
	//最终所有字符一致 
	//s为01字符串
	//尽可能让中间的字符串一样，然后翻转两侧
	public long minimumCost(String s) {
		long min = 0;
		for (int i = 1; i < s.length(); i++) {
			min += s.charAt(i - 1) == s.charAt(i) ? 0 : Math.min(i, s.length() - i);
		}
		return min;
	}
	public static void main(String args[]) {
		Solution solution = new Solution();
		long ans = solution.minimumCost("0011");
		System.out.print(ans);
	}
}
