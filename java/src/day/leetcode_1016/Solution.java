package day.leetcode_1016;

import java.util.HashSet;

class Solution {
	//求 1-n中的所有元素能否被s的子串表示
	//暴力匹配
    public boolean queryString(String s, int n) {
    	HashSet<Integer> set = new HashSet<>();
    	int pre = 0;
    	int cur = 0;
    	for(int i = 1;i<=s.length();++i)//所有长度枚举
    	{
    		int j;
            cur = 0;
    		for(j = 0;j<i;++j)//长度
    		{
    			cur=cur*2+stoi(s.charAt(j));
    		}
    		set.add(cur);
    		for(j = i;j<s.length()&&set.size()-pre<(int)Math.pow(2,i);++j)
    		{
    			if(s.charAt(j-i)=='0')
    				cur = cur*2+stoi(s.charAt(j));
    			else 
    				cur = (cur-(int)Math.pow(2,i-1))*2+stoi(s.charAt(j));
    			set.add(cur);
    		}
    		pre = set.size();
    	}
    	for(int i = 1;i<=n;++i)
    		if(!set.contains(i))
    			return false;
    	return true;
    }

	private int stoi(char c) {
		return c-'0';
	}
	//求 1-n中的所有元素能否被s的子串表示
	//自带方法真好用
	/**
    public boolean queryString(String s, int n) {
    	for(int i = 1;i<=n;++i)
    		if(!s.contains(Integer.toString(i,2)))
                return false;
    	return true;
    }*/
}

