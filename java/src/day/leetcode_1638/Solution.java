package day.leetcode_1638;

class Solution {
	//寻找子串对，子串对长度相等，仅相差一个字符
	//两个字符串都小于100
	//暴力 O(n^4)
	/*
    public int countSubstrings(String s, String t) {
    	int ans = 0;
    	for(int i = 0;i<s.length();++i)
    	{
    		for(int j = 0;j<t.length();++j)
    		{
    			int diff = 0;
    			for(int k = 0;k+i<s.length()&&j+k<t.length();++k)
    			{
    				diff += s.charAt(i+k) == t.charAt(j+k)?0:1;
    				if(diff == 1)
    					++ans;
    				else if(diff>1)
    					break;
    			}
    		}
    	}
    	return ans;
    }*/
    //三维dp
    //s的第i个，t的第j个，相差k个,有x个组合
    //if s[i] == t[j]
    // dp[i][j][1/0] = dp[i-1][j-1][1/0]
    //else
    // dp[i][j][1] = dp[i][j][0] + 1
	public int countSubstrings(String s, String t) {
    	int[][]dp1 = new int[s.length()+1][t.length()+1];
        int[][]dp2 = new int[s.length()+1][t.length()+1];
    	int ans = 0;
    	for(int i = 0;i<s.length();++i)
    	{
    		for(int j =0;j<t.length();++j)
    		{
    			if(s.charAt(i) == t.charAt(j))
    			{
    				dp1[i+1][j+1] = 1+dp1[i][j];
        			dp2[i+1][j+1] = dp2[i][j];
				}
    			else 
    			{
    				dp2[i+1][j+1] = dp1[i][j] + 1;
				}
    			ans+=dp2[i+1][j+1];
    		}
    	}
    	return ans;
    }
}
