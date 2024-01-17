package day.leetcode_1027;

import java.util.Arrays;

class Solution {
    //找最长的等差子序列 序列元素可以不相邻，但要有序
	//dp[i][j]以i为结尾的,公差为j的最长等差子序列长度
	//公差不会超过500
	//dp[i+1][j] = dp[i][0...i] + 1 if nums[j] - nums[0...i] = j
	//dp[i+1][j] = 1 
	//暴力O(n^2)
	/**
    public int longestArithSeqLength(int[] nums) {
    	int[][] dp = new int[nums.length][1001];
    	int ans = 1;
    	for(int i = 0;i<nums.length;++i)
    	    Arrays.fill(dp[i], 1);
    	for(int i = 1;i<nums.length;++i)
    	{
    		for(int k = i-1;k>=0;--k)
    		{
    			int index = nums[i] - nums[k] >=0?nums[i] - nums[k]:1001+nums[i]-nums[k];
    			dp[i][index] = Math.max(dp[i][index], dp[k][index]+1);
    			ans = Math.max(ans, dp[i][index]);
    		}
    	}
    	return ans;
    }**/
	//空间优化
	public int longestArithSeqLength(int[] nums) {
        int min = 501,max = 0;
        for(int i = 0;i<nums.length;++i)
        {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int scope = (max-min)*2 + 1;
    	int[][] dp = new int[nums.length][scope];
    	int ans = 1;
    	for(int i = 0;i<nums.length;++i)
    	    Arrays.fill(dp[i], 1);
    	for(int i = 1;i<nums.length;++i)
    	{
    		for(int k = i-1;k>=0;--k)
    		{
    			int index = nums[i] - nums[k] >=0?nums[i] - nums[k]:scope+nums[i]-nums[k];
    			dp[i][index] = Math.max(dp[i][index], dp[k][index]+1);
    			ans = Math.max(ans, dp[i][index]);
    		}
    	}
    	return ans;
    }
    public static void main(String args[]) {
		//Solution solution = new Solution();
		//int ans = solution.longestArithSeqLength(new int[] {20,1,15,3,10,5,8});
	}
}