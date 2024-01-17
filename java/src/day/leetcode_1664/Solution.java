package day.leetcode_1664;


class Solution {
	    //任意删除一个元素，数组奇偶位相等的可能
		//删除一个元素，该元素后续元素的奇偶性将翻转
		//动态规划，两次遍历
		//第一次遍历记录后续元素奇偶和
		//第二次遍历逐个元素分析
	   /**
	    public int waysToMakeFair(int[] nums) {
	    	int ans = 0;
	    	int cur1 = 0;//前i位奇数和
	    	int cur2 = 0;//前i为偶数和
	    	int[] sum1 = new int[nums.length];//从某元素开始的，奇数位和
	    	int[] sum2 = new int[nums.length];//从某元素开始的，偶数位和
	    	if((nums.length -1) % 2 == 0)//该数是偶数
	    	{
	    		sum1[nums.length-1] = 0;
	    		sum2[nums.length-1] = nums[nums.length-1];
	    	}
	    	else 
	    	{
	    		sum1[nums.length-1] = nums[nums.length-1];
	    		sum2[nums.length-1] = 0;
			}
	    	for(int i = nums.length -2 ;i>=0;--i)
	    	{
	    		if(i % 2 == 0)//该数是偶数
	    		{
	    			sum1[i] = sum1[i+1];
	    			sum2[i] = sum2[i+1] + nums[i];
	    		}
	    		else 
	    		{
	    			sum1[i] = sum1[i+1] + nums[i];
	    			sum2[i] = sum2[i+1];
				}
	    	}
	    	for(int i =0;i<nums.length;++i)
	    	{
	    		if(i%2==0)//删除一个偶数，后续奇数变偶数
	    		{
	    			if(cur2 + sum1[i] == cur1 + sum2[i] - nums[i])
	    				++ans;
	    			cur2+=nums[i];
	    		}
	    		else
	    		{
	    			if(cur2 + sum1[i] - nums[i] == cur1 + sum2[i])
	    				++ans;
	    			cur1+=nums[i];
	    		}
	    	}
	    	return ans;
	    }
	    */
		public int waysToMakeFair(int[] nums) {
        int[] dp = new int[nums.length + 1];
        // dp[i]表示(0,1,2...,i-1)的奇偶数之差(偶数和-奇数和)
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + ((i & 1) == 0 ? nums[i - 1] : -nums[i - 1]);
        }
        int rev = 0;
        for (int i = 1; i < dp.length; i++) {
            //当删除第 i 个元素后(下标 i-1)，此元素之前奇偶数之差为 dp[i-1](偶-奇)
            //此元素之后奇偶数之差为 dp[n]-dp[i](偶-奇)
            //由于删除 i 后，奇偶翻转，所以只需判断相等即可
            if (dp[i - 1] == dp[nums.length] - dp[i]) {
                ++rev;
            }
        }
        return rev;
    }
}
