package day.leetcode_2559;

import java.util.HashSet;

class Solution {
    //queries 查询范围
	//words 单词表
	//目标是queries的范围内，头尾是元音字母的word
	HashSet<Character> set = new HashSet<Character>();
	
    public int[] vowelStrings(String[] words, int[][] queries) {
    	set.add('a');
    	set.add('e');
    	set.add('i');
    	set.add('o');
    	set.add('u');
    	int[] dp = new int[words.length+1];
    	int[] ans = new int[queries.length];
    	for(int i = 1;i<dp.length;++i)
    	{
    		dp[i] = dp[i-1] + (set.contains(words[i-1].charAt(0))&&set.contains(words[i-1].charAt(words[i-1].length()-1))?1:0);
    	}
    	for(int i = 0;i<ans.length;++i)
    	{
    		ans[i] = dp[queries[i][1]+1] - dp[queries[i][0]];
    	}
    	return ans;
    }
}
