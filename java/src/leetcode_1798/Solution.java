package leetcode_1798;

class Solution {
    //连续值一定从0开始
	//dp 截止第i位，可以组成多少连续的数
	//前i位可以组成 0 - len-1
	//第i为位要能连上，需要满足 conis[i]+（0-len-1) 包含 len 
    public int getMaximumConsecutive(int[] coins) {
    	Arrays.sort(coins);
    	int len = 1;
    	if(coins[0]==1)
    	{
    		for(int coin :coins)
    		{
    			if(coin<=len)
    				len+=coin;
                else 
                    break;
    		}
    	}
    	return len;
    }
}
