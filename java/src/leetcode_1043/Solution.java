package leetcode_1043;

class Solution {
    //切片，k份，大数权值尽可能大
	/**
	 * eg:	输入：arr = [1,15,7,9,2,5,10], k = 3
			输出：84
			解释：数组变为 [15,15,15,9,10,10,10]
	 * @param arr
	 * @param k
	 * @return
	 */
	//dp[i][j]
	//当以i为第j个切片的结尾，本切片长度为k,此时的数组和
	//dp[i][j][k] = dp[i-1][j] dp[i-1][j-1]
	//i<=len j<=k
	//ans = dp[len-1][k-1]
	//需要记录区间的最大值
	/*
    public int maxSumAfterPartitioning(int[] arr, int k) {
    	int[][] dp = new int[arr.length][k];
    	int[][] lens = new int[arr.length][k];
    	dp[0][0] = arr[0];
    	lens[0][0] = 1;
    	for(int i = 1;i<arr.length;++i)
    	{
    		for(int j = (arr.length-i>k?0:k-arr.length+i);j<k&&j<=i;++j)
    		{
    			if(j>0)
    			{
    				int max = arr[i-1];//第j段最大值
    				int len = lens[i-1][j];
    				for(int m = 1;m<len;++m)
    					max = Math.max(max,arr[k-len]);
    				if(len==0||dp[i-1][j-1]+arr[i]>dp[i-1][j]-max*len+(len+1)*Math.max(max, arr[i]))
    				{
    					dp[i][j] = dp[i-1][j-1]+arr[i];
    					lens[i][j] = 1;
    				}
    				else {
    					dp[i][j] = dp[i-1][j]-max*len+(len+1)*Math.max(max, arr[i]);
    					lens[i][j] = len+1;
    				}
    			}	
    			else 
    			{
    				dp[i][0] = Math.max(arr[i], dp[i-1][0]/i)*(i+1);
    			}
    		}
    	}
    	return dp[arr.length-1][k-1];
    }*/
	//题目看错了，不是分成k份，是最长为k,焯
		//dp[i][j]第i个数，是子数组中的第j个数
	    public int maxSumAfterPartitioning(int[] arr, int k) {
	        int[] dp = new int[k];
	        int[] record = new int[arr.length];
	        int num = 0,max = 0;
	        dp[0] = arr[0];
	        record[0] = dp[0];
	        for(int i = 1;i<arr.length;++i)
	        {
	        	num = 0;
	    		max = 0;
	        	for(int j =0;j<k&&j<=i;++j)
	        	{
	        		max = 0;
	        		num = Math.max(num, arr[i-j]);
	        		if(i-j>=1)
	        			max = Math.max(max, record[i-j-1]);
	        		dp[j] = max+num*(j+1);
	        		record[i] = Math.max(record[i], dp[j]);
	        	}
	        }
	        return record[arr.length-1];
	    }
	
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int ans = solution.maxSumAfterPartitioning(new int[] {1,15,7,9,2,5,10}, 3);
    }
}
//降维优化
class Solution1 {
    //题目看错了，不是分成k份，是最长为k,焯
	//dp[i][j]第i个数，是子数组中的第j个数
    public int maxSumAfterPartitioning(int[] arr, int k) {
	        int cur = 0;
	        int[] record = new int[arr.length];
	        int num = 0,max = 0;
	        record[0] = arr[0];
	        for(int i = 1;i<arr.length;++i)
	        {
	        	num = 0;
	    		max = 0;
	        	for(int j =0;j<k&&j<=i;++j)
	        	{
	        		max = 0;
	        		num = Math.max(num, arr[i-j]);
	        		if(i-j>=1)
	        			max = record[i-j-1];
	        		record[i] = Math.max(record[i], max+num*(j+1));
	        	}
	        }
	        return record[arr.length-1];
	    }
}