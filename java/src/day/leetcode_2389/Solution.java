package day.leetcode_2389;

import java.util.Arrays;

class Solution {
    //ans[i] 对应 nums的小于queries 的 子序列最长长度
    //暴力搜索 O(n^2)
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] ans = new int[queries.length];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;++i)
            dp[i] = dp[i-1]+nums[i];
        for(int i = 0;i<queries.length;++i)
        {
            ans[i] = -1;
            for(int j=0;j<dp.length;++j)
            {
                if(dp[j]>queries[i])
                {
                    ans[i] = j;
                    break;
                }
            }
            if(ans[i] == -1)
                ans[i] = dp.length;
        }
        return ans;
    }
    //优化 二分查找
}
