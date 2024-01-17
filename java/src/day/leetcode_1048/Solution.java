package day.leetcode_1048;

import java.util.Arrays;

class Solution {
	//找出单词链，其中，每个word都是后一个词语的子序列，且长度差1
	//dp，以i个单词为结尾，单词链的长度
	//暴力匹配
	//可以哈希优化，对一个word，去掉任意一个字符，进哈希表查询
    public int longestStrChain(String[] words) {
    	int[] dp = new int[words.length];
    	Arrays.fill(dp,1);
    	int ans = 1;
    	int index1 = 0;//起始比较点
    	int index2 = 0;
    	int len = 0;//前置长度
    	Arrays.sort(words,(o1,o2)->(o1.length()-o2.length()));//长度排序
    	for(int i = 0;i<dp.length;++i)
    	{
    		for(int j = 0;j<i;++j)
    		{
    			if(words[j].length()+1!=words[i].length())
    				continue;
    			int k = 0;
    			for( ;k<words[j].length();++k)
    			{
    				if(words[j].charAt(k) != words[i].charAt(k))
    					break;
    			}
    			for( ;k<words[j].length();++k)
    			{
    				if(words[j].charAt(k) != words[i].charAt(k+1))
    					break;
    			}
    			if(k == words[j].length())//是前身
    				dp[i] = Math.max(dp[i], dp[j]+1);
    		}
    	}
    	for(int i = 0;i<dp.length;++i)
    		ans = ans<dp[i]?dp[i]:ans;
    	return ans;
    }
}