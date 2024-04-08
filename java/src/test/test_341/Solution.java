package test.test_341;

import java.util.Scanner;

public class Solution {
	public int[] rowAndMaximumOnes(int[][] mat) {
		int num = 0;
		int line = 0;
		for(int i = 0;i<mat.length;++i)
		{
			int cur = 0;
			for(int j : mat[i])
			{
				if(j == 1)
					++cur;
			}
			if(cur>num)
			{
				num = cur;
				line = i;
			}
		}
		return new int[] {line,num};
	}
	public int maxDivScore(int[] nums, int[] divisors) {
		int ans = 0;
		int num = 0xffffffff;
		for(int i :divisors)
		{
			int cur = 0;
			for(int j : nums)
			{
				if(j%i==0)
					++cur;
			}
			if(cur>ans)
			{
				ans = cur;
				num = i;
			}
			else if(cur == ans)
			{
				num = Math.min(i, num);
			}
		}
		return num;
    }
	//向word中插入abc,使之成为abc
	public int addMinimum(String word) {
		StringBuilder ans = new StringBuilder();
		int count = 0;
		for(char c:word.toCharArray())
		{
			if(c == 'a')
			{
				if(count == 0)
					ans.append("a");
				else if(count == 1)
					ans.append("bca");
				else 
					ans.append("ca");
				count = 1;
			}
			else if(c== 'b')
			{
				if(count == 0)
					ans.append("ab");
				else if(count == 1)
					ans.append("b");
				else 
					ans.append("cab");
				count = 2;
			}
			else 
			{
				if(count == 0)
					ans.append("abc");
				else if(count == 1)
					ans.append("bc");
				else 
					ans.append("c");
				count = 0;
			}
		}
		if(ans.charAt(ans.length()-1)=='a')
			count = 2;
		else if(ans.charAt(ans.length()-1)=='b')
			count =1;
		return ans.length()-word.length()+count;
    }
	public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
		boolean[][] map = new boolean[n][n];
		//找一组不
		int[] price1 = new int[n];
		int[] price2 = new int[n];
		for(int i = 0;i<n;++i)
		{
			map[edges[i][0]][edges[i][1]] = true;
		}
		return 0;
		
    }
	public static void main(String args[]) {
		Solution solution = new Solution();
		Scanner inScanner = new Scanner(System.in);
		int ans = solution.addMinimum("abc");
		System.out.println(ans);
		inScanner.close();
		
	}
}
