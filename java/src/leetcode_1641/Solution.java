package leetcode_1641;

import java.util.Scanner;


class Solution {
	//dp
    //dp[i]指以i作为开头的字符串数目
    public int countVowelStrings(int n){
        int[] dp = new int[5];
        for(int i = 0;i<5;++i)
            dp[i] = 1;
        for(int i = 2;i<=n;++i)
        {
            dp[0] = dp[0]+dp[1]+dp[2]+dp[3]+dp[4];
            dp[1] = dp[1]+dp[2]+dp[3]+dp[4];
            dp[2] = dp[2]+dp[3]+dp[4];
            dp[3] = dp[3]+dp[4];
            dp[4] = dp[4];
        }
        return dp[0]+dp[1]+dp[2]+dp[3]+dp[4];
    }
    //组合数学
    /** 
    public int countVowelStrings(int n) {
    	return (n+4)*(n+3)*(n+2)*(n+1)/24;
    }
    **/
    //排列树
    /**
    public int countVowelStrings(int n) {
    	return backtrack(5, n);
    }
    public int backtrack(int start,int len)
    {
    	if(start == 1)
    		return 1;
    	if(len == 1)
    		return start;
    	int ans = 0;
    	for(int i = start;i>=1;--i)
    		ans+=backtrack(i, len-1);
    	return ans;
    }
    **/
    public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);
    	Solution solution = new Solution();
    	int anString = solution.countVowelStrings(2);
    	System.out.print(anString);
    }
}
