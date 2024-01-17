package day.leetcode_1031;

class Solution {
    //找到两个长度指定的子数组，他们的和最大
    //子数组不重叠
    //dp 计算限定长度子数组的最大值，找到最大组合
    //dp O(N) 组合 O(n^2) 暴力
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] dp1 = new int[nums.length-firstLen+1];
        int[] dp2 = new int[nums.length-secondLen+1];
        int ans = 0;
        for(int i = 0;i<firstLen;++i)
            dp1[0]+=nums[i];
        for(int i = 0;i<secondLen;++i)
            dp2[0]+=nums[i];
        for(int i = 1;i<dp1.length;++i)
            dp1[i] = dp1[i-1]-nums[i-1]+nums[i+firstLen-1];
        for(int i = 1;i<dp2.length;++i)
            dp2[i] = dp2[i-1]-nums[i-1]+nums[i+secondLen-1];
        for(int i = 0;i<dp1.length;++i)
        {
        	for(int j = 0;j+secondLen<i;++j)
        		ans = Math.max(ans,dp1[i]+dp2[j]);
        	for(int j = i+firstLen;j<dp2.length;++j)
        		ans = Math.max(ans,dp1[i]+dp2[j]);
        }
        return ans;
     }
}
/**
 * 优化 dp +滑动窗口 O(N)
 * class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(help(nums, firstLen, secondLen), help(nums, secondLen, firstLen));
    }

    public int help(int[] nums, int firstLen, int secondLen) {
        int suml = 0;
        for (int i = 0; i < firstLen; ++i) {
            suml += nums[i];
        }
        int maxSumL = suml;
        int sumr = 0;
        for (int i = firstLen; i < firstLen + secondLen; ++i) {
            sumr += nums[i];
        }
        int res = maxSumL + sumr;
        for (int i = firstLen + secondLen, j = firstLen; i < nums.length; ++i, ++j) {
            suml += nums[j] - nums[j - firstLen];
            maxSumL = Math.max(maxSumL, suml);
            sumr += nums[i] - nums[i - secondLen];
            res = Math.max(res, maxSumL + sumr);
        }
        return res;
    }
}

*/
