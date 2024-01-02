package test339;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	//子串0在1前，且0数量同1
	//dp
	//if(s[i] == 0)
	//else
	public int findTheLongestBalancedSubstring(String s) {
		int ans = 0;
		int[] dp1 = new int[s.length()+1];//第i位，前方连续的0
		int[] dp2 = new int[s.length()+1];//第i为，后方连续的1
		for(int i = 1;i<=s.length();++i)
		{
			if(s.charAt(i-1) == '0')
				dp1[i] = dp1[i-1]+1;
			else {
				dp1[i] = 0;
			}
		}
		for(int i = s.length()-1;i>=0;--i)
		{
			if(s.charAt(i) == '1')
				dp2[i] = dp2[i+1]+1;
			else {
				dp2[i] = 0;
			}
		}
		for(int i = 0;i<s.length();++i)
		{

			ans = Math.max(ans, Math.min(dp1[i],dp2[i])*2);
		}
		return ans;
    }

	public List<List<Integer>> findMatrix(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		int row = 0;
		for(int i : nums)
		{
			if(count.containsKey(i))
			{
				count.put(i, count.get(i)+1);
				row = Math.max(row, count.get(i));//计算行
			}
			else {
				count.put(i, 1);
				row = row == 0?1:row;
			}
		}
		while(row>0)
		{
			ArrayList<Integer> line = new ArrayList<>();
			for(int num:count.keySet())
			{
				if(count.get(num) >0 )
				{
					count.put(num, count.get(num)-1);
					line.add(num);
				}	
			}
			ans.add(line);
			--row;
		}
		return ans;
	}
	//1号吃k块，2号吃 n - k块，计算最大得分
	//i被1吃，被2吃
	//dp[k][n] 第k块吃的n
	public int miceAndCheese(int[] reward1, int[] reward2, int k) {
		int[][] cur = new int[reward1.length][2];
		for(int i = 0;i<reward1.length;++i)
		{
			cur[i][0] = reward1[i];
			cur[i][1] = reward2[i];
		}
		Arrays.sort(cur,(o1,o2)->((o2[0]-o2[1])-(o1[0]-o1[1])));
		int ans = 0;
		for(int i = 0;i<k;++i)
			ans+=cur[i][0];
		for(int i = k;i<cur.length;++i)
			ans+=cur[i][1];
		return ans;
		
	}
	/**
	 * bfs
	 * 寻找p能去的位置
	 * 非边界{ p-k+1 ,p+k-1}
	 * 有单边界{ 0， k-p,p+k-1} {p-k+1,p-k,n}
	 * @param n
	 * @param p n,p表示 0-n-1的数组arr中，只有下标p处值为1，其他为0 arr[p] = 0
	 * @param banned arr[banned[i]] = 0,banned[i] !=p
	 * @param k 进行若干次操作，翻转长为k的子数组,让p转移到i处，且p不可经过banned
	 * @return
	 */
	public int[] minReverseOperations(int n, int p, int[] banned, int k) {
		int[] ans = new int[n];
		ans[p] = 0;
		for(int i = 0;i<banned.length;++i)
			ans[banned[i]] = -1;
		for(int i =0;i<n;++i)
			if(ans[i]!=-1&&i!=p)
				ans[i]=-2;
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(p);
		int count  =0;
		while(!bfs.isEmpty())
		{
			++count;
			int cur = bfs.poll();
			if(ans[cur] == -1)
				continue;
			int left = 0,right = n-1;//左右端
			if(p+1>=k)
				left = p - k + 1;
			if(n-p>=k)
				right = p + k-1;
			for(int i = right;i>p;i-=2)
			{
				if(ans[i] == -2&&i!=p)
				{
					ans[i] = count;
					bfs.add(i);
				}
			}
			for(int i = left;i<p;i+=2)
			{
				if(ans[i] == -2&&i!=p)//未访问
				{
					ans[i] = count;
					bfs.add(i);
				}
			}
		}
		for(int i =0;i<n;++i)
			if(ans[i]==-2)
				ans[i]=-1;
		return ans;
    }
	public static void main(String args[]) {
		//Scanner inScanner = new Scanner(System.in);
		//Solution solution = new Solution();
		//int[] ans = solution.minReverseOperations(4,0,new int[] {1,2},4);
	}
}
