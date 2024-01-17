package day.leetcode_1092;

import java.util.Scanner;

class Solution {
	//两字符串最长子序列+剩余
	//二维dp
	//dp[i][j]指以str1[i:n]str2[j:n]作为子序列的最短字符串长度
	//why ？ 内含两个字符串作为子序列的母字符串，一定含这两个字符串的子序列
	//LSC
	//str1[i] == str2[j]
	//dp[i][j] = dp[i+1][j+1] +1
	//dp[i][j] = min(dp[i+1][j] , dp[i][j+1]) +1
	//前提i<n,j<m
	/*
	 * dp[i][j] = m-j i=n,j<m
	 * 			= n-i i<n,j=m
	 * 			= 0 i=n,j=m
	 */
    public String shortestCommonSupersequence(String str1, String str2) {
    	int n = str1.length(),m = str2.length();
    	int[][] dp = new int[n+1][m+1];
    	for(int i = 0;i<n;++i)
    		dp[i][m] = n-i;
    	for(int j = 0;j<m;++j)
    		dp[n][j] = m-j;
    	dp[n][m] = 0;
    	for(int i = n-1;i>=0;--i)
    	{
    		for(int j = m-1;j>=0;--j)
    		{
    			if(str1.charAt(i) == str2.charAt(j))
    				dp[i][j] = dp[i+1][j+1] + 1;
    			else 
					dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) +1;
    		}
    	}
    	StringBuilder ans = new StringBuilder();
    	int index1 = 0, index2 = 0;
    	while(index1<n&&index2<m)
    	{
    		if(str1.charAt(index1) == str2.charAt(index2))
    		{
    			ans.append(str1.charAt(index1));
    			++index1;
    			++index2;
    		}
    		else if(dp[index1][index2] == dp[index1+1][index2]+1)
    		{
    			ans.append(str1.charAt(index1));
    			++index1;
    		}
    		else if(dp[index1][index2] == dp[index1][index2+1]+1)
    		{
    			ans.append(str2.charAt(index2));
    			++index2;
    		}
    	}
    	if(index1<n)
    		ans.append(str1.substring(index1));
    	else
    		ans.append(str2.substring(index2));
        return ans.toString();
    }
    public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);
    	String str1 = in.next();
    	String str2 = in.next();
    	Solution solution = new Solution();
    	String anString = solution.shortestCommonSupersequence(str1, str2);
    	System.out.print(anString);
    }
}
