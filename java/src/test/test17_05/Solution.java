package test.test17_05;

import java.util.HashMap;
import java.util.regex.Pattern;//leetcode不能用这个正则23333

class Solution {
    //计算权值，dp[i]为到第i位时，从头开始，字母和数字的数量差
    //找到最长的i-j dp[j] - dp[i] = 0
    //哈希
    //依然是一个前缀和
    public String[] findLongestSubarray(String[] array) {
    	//哈希表，键值为字母和数字数量差，值为数组下标
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>(array.length+1);
        int num1 = 0,num2 = 0;//统计字母和数字的数量
        int len = 0, tail = 0;
        index.put(0,-1);
        for(int i = 0;i<array.length;++i)
        {
        	char c = array[i].charAt(0);
        	if(c<='9'&&c>='0')
        		++num2;
        	else
        		++num1;
        	if(index.containsKey(num1-num2))//出现子数组内，字母数和数字数相同
        	{
        		if(len < i - index.get(num1-num2))
        		{
        			tail = i;
        			len = tail - index.get(num1-num2);
        		}
        	}
        	else 
				index.put(num1-num2, i);
        }
        String[] ans = new String[len];
        System.arraycopy(array,tail-len+1,ans,0,len);
        /*
        for(int i = tail - len+1 , j = 0; i<=tail ;++i,++j)
            ans[j] = array[i];
            */
        return ans;
    }
}
