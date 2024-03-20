package day.leetcode_1969;
/*
 * @lc app=leetcode.cn id=1969 lang=java
 *
 * [1969] 数组元素的最小非零乘积
 */

// @lc code=start
class Solution {
    //快速幂
    static long mod = 1000000007;
    public int minNonZeroProduct(int p) {
        long base = fastPower(2, p)-1;//基底1
        long value = (long)1<<(p-1);//幂数
        return (int)(fastPower(base-1 , value-1)*base % mod);
    }
    public long fastPower(long base, long power)
	{
		long ans = 1;
		while(power >0)
		{
			if(power%2==1)
				ans = ans*base%mod;//取末尾位数,收集分离的底数
			power/=2;
			base = base*base%mod;
		}
		return ans;
	}
}
// @lc code=end

