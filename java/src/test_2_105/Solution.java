package test_2_105;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	//贪心，最小俩个值
	public int buyChoco(int[] prices, int money) {
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for(int i = 0;i<prices.length;++i)
		{
			if(min1>prices[i])
			{
				min2 = min1;
				min1 = prices[i];
			}
			else if(min1 == prices[i])
			{
				min2 = prices[i];
			}
			else {
				if(min2>prices[i])
				{
					min2 = prices[i];
				}
			}
		}
		if(money<min1+min2)
			return money;
		return money-min1-min2;
    }
	//将s中的字符串用dictionary中的字符串抵消，使s内剩下的字符最少
	//dictionary内字符串可以重复使用
	//暴力遍历,回溯法,爆
	//dp剪枝
	public int minExtraChar(String s, String[] dictionary) {
		Arrays.sort(dictionary,(o1,o2)->(o1.length()-o2.length()));
		int len = dictionary[dictionary.length-1].length();
		boolean[][] record = new boolean[s.length()][len];
		int ans = s.length();
		boolean judge = true;
		for(int i = 0;i<s.length();++i)
		{
			for(int j = 0;j<dictionary.length;++j)
			{
				int k = 0;
				for(k = 0;k<dictionary[i].length();++k)
				{
					if(s.charAt(i+k) != dictionary[i].charAt(k))
						break;
				}
				if(k == dictionary[i].length())
					record[i][dictionary[i].length()] = true;
			}
		}
		ans = dfs(record, 0,s.length());
		return ans;
		/**
		StringBuilder str = new StringBuilder(s);
		int ans[] = new int[s.length()];
		
		return dfs(s, dictionary,0);
		*/
    }
	int dfs(boolean[][] record,int index,int len)
	{
		int ans = len;
		boolean judge = true;
		int jump = 0;
		for(int i = index;i<record.length;++i)
		{
			judge = true;
			for(int j = 0;j<record[i].length;++j)
			{
				if(record[i][j])
				{
					judge = false;
					ans =Math.min(ans, dfs(record, index+j,len-(index+j)));
				}
			}
			if(judge)
				++jump;
		}
		
		
		return ans;
	}
	public static void main(String args[]) {
		Solution solution = new Solution();
		int ans = solution.minExtraChar("leetscode",new String[] {"leet","code","leetcode"});
		/*int ans = solution.minExtraChar("cmmcxfdepqalvjqphhzjjomjwtmlkidxdhhhlhbxe", new String[] {"e","lhbx","k","lxtv",
				"hhz","j","n","deqfw","onxcv","dnq","dxy","z","py","sg","nycr",
				"mcxfde","tmudaz","y","q","i","igo","msqki","p","ls","qmzng",
				"errfl","hcnwcb","rbvov","h","ljvdp","erucpm","dxa","lvjqp",
				"tbiic","jomjwt","mlkidx","dtu","qw","zn","o","dhhh"});*/
		//long ans = solution.maximumOr(new int[] {12,9}, 1);
		System.out.print(ans);
	}
}

