package test_345;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int[] circularGameLosers(int n, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		int cur = (1+k)%n;
		if(cur == 0)
			cur = n;
		int count = 1;
		set.add(1);
		while(!set.contains(cur)&&count<n)
		{
			++count;
			set.add(cur);
			cur = (cur+count*k)%(n);
			if(cur == 0)
				cur = n;
		}
		int[] ans = new int[n-set.size()];
		count = 0;
		for(int i = 1;i<=n;++i)
		{
			if(!set.contains(i))
				ans[count++] = i;
		}
		return ans;
	}
	//是否存在ori
	//derived[n-1] = ori[n-1]^ori[0]
	//derived[i] = ori[i]^ori[i+1]
	public boolean doesValidArrayExist(int[] derived) {
		if(derived.length == 1)
		{
			if(derived[0] == 1)
				return false;
			else {
				return true;
			}
		}
		int[] ori = new int[derived.length];
		ori[0] = 0;
		for(int i = 1;i<derived.length;++i)
		{
			ori[i] = ori[i-1]^derived[i-1];
		}
		if((ori[derived.length-1]^ori[0])==derived[derived.length-1])
			return true;
		ori[0] = 1;
		for(int i = 1;i<derived.length;++i)
		{
			ori[i] = ori[i-1]^derived[i-1];
		}
		if((ori[derived.length-1]^ori[0])==derived[derived.length-1])
			return true;
		return false;
    }
	//可从第一列出发，求最多的右移次数 bfs , dfs
	//dp
	public int maxMoves(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int ans = 0;
		int[][] dp = new int[row][col];
		for(int i = 0;i<row;++i)
			Arrays.fill(dp[i], 0);
		for(int j = col-2;j>=0;--j)
		{
			for(int i = 0;i<row;++i)
			{
				if(i == 0)
				{
					for(int k = 0;k<2;++k)
					{
						if(grid[i][j]<grid[i+k][j+1])
							dp[i][j] = Math.max(dp[i][j], dp[i+k][j+1]+1);
					}
				}
				else if(i==row-1)
				{
					for(int k = -1;k<1;++k)
					{
						if(grid[i][j]<grid[i+k][j+1])
							dp[i][j] = Math.max(dp[i][j], dp[i+k][j+1]+1);
					}
				}
				else {
					for(int k = -1;k<2;++k)
					{
						if(grid[i][j]<grid[i+k][j+1])
							dp[i][j] = Math.max(dp[i][j], dp[i+k][j+1]+1);
					}
				}
			}
		}
		for(int i = 0 ;i<dp.length;++i)
			ans = Math.max(ans, dp[i][0]);
		return ans;
    }
	//判断多少个分量，再判断是否完全
	//找分量，和对应边数量，看边数量能否对应
	public int countCompleteComponents(int n, int[][] edges) {
		int ans = 0;
		int sum = 0;
		int count = 0;
		int start =0;
		int len = 0;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0;i<n;++i)
			map.put(i,new ArrayList<>());
		for(int i = 0;i<edges.length;++i)
		{
			ArrayList<Integer> cur = map.get(edges[i][0]);
			cur.add(edges[i][1]);
			map.put(edges[i][0], cur);
			cur = map.get(edges[i][1]);
			cur.add(edges[i][0]);
			map.put(edges[i][1], cur);
		}
		while(count<n)
		{
			Queue<Integer> queue = new LinkedList<>();
			queue.add(start);
			ArrayList<Integer> cur = map.get(start);
			len = cur.size();
			while(!queue.isEmpty())
			{
				while(!cur.isEmpty())
				{
					cur.remove(0);
				}
			}
		}
		return 0;
		
    }
	public static void main(String args[]) {
		Solution solution = new Solution();
		int ans = solution.maxMoves(new int[][] {{131,1,95,208,38,257,123,204,101},{185,165,292,109,266,259,97,234,60},{55,281,38,61,204,243,32,54,164},{106,230,202,4,65,243,89,139,211},{192,246,11,294,119,43,250,161,110},{71,279,288,173,64,48,216,26,276},{23,206,152,106,288,286,270,131,12},{115,64,251,108,194,295,131,249,121}});
		System.out.print(ans);
	}
}
