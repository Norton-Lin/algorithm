package day.leetcode_lcp_33;

import java.util.Arrays;

class Solution {
	//最少次数使所有vat满
	//操作： 1. bucket[i]+1
	//		2. 装水
	//枚举装水次数 < 最大水量
	//枚举每个蓄水次数的需要增长次数
    public int storeWater(int[] bucket, int[] vat) {
    	int ans = Integer.MAX_VALUE;
    	int cur = 0;
    	int border = Arrays.stream(vat).max().getAsInt();//最大水缸蓄水量
    	if(border == 0)
    		return 0;
    	for(int i = 1;i<=border&&i<ans;++i)//枚举蓄水次数
    	{
    		cur = 0;
    		for(int j = 0;j<bucket.length;++j)//枚举增长次数
    			cur += Math.max(0,(vat[j]+i-1)/i-bucket[j]);
    		ans = Math.max(ans, cur + i);
    	}
    	return ans;
    }
    
}
