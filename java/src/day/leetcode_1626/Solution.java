package day.leetcode_1626;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	//先排序，年龄由小到大，同年龄，按分数由小到大
	//dp[i]以i为结尾
	public int bestTeamScore(int[] scores, int[] ages) {
		int[][] data = new int[scores.length][2];
		int[] dp = new int[scores.length];
		int age = 0;
		for(int i = 0;i<scores.length;++i)
    	{
    		data[i][0] = ages[i];
    		data[i][1] = scores[i];
    		if(ages[i]>age)
    			age = ages[i];
    	}
		//得到一个年龄由高到低的序列,同年龄，按分数由小到大
    	Arrays.sort(data, new Comparator<int[]>(){
    		@Override
    		public int compare(int[] o1,int[] o2) {
    			return o1[0] == o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
    		}
    	});
		int ans = 0;
		int cur = 0;
		for(int i = 0;i<scores.length;++i)//新人的年龄一定更小
		{
			cur = 0;
			for(int j = i-1;j>=0;--j)//此时队员的年龄都比新人大，
			{
				if(data[j][0] == data[i][0])
					cur = Math.max(dp[j],cur);
				else
				{
					if(data[j][1]<=data[i][1])
						cur = Math.max(dp[j], cur);
				}
			}
			dp[i] = cur  +data[i][1];
			ans = Math.max(dp[i], ans);
		}
		return ans;
	}
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int ans = solution.bestTeamScore(new int[]{1,3,7,3,2,4,10,7,5}, new int[] {4,5,2,1,1,2,4,1,4});
		System.out.print(ans);
	}
}
