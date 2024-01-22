/*
 * @lc app=leetcode.cn id=2809 lang=java
 *
 * [2809] 使数组和小于等于 x 的最少时间
 */

import java.util.List;
import java.util.Arrays;
// @lc code=start

class Solution {
    //每一秒 nums1[i]+=nums2[i]
    //选择一个nums1[i] 清零
    //求何时 sum<x
    //贪心， 每次清空谁，清空最大的 或者增长最慢的
    //每次选择增长最慢的数组
    //dp + 贪心
    //dp表示本次操作对总值的损耗
    //dp[i][j] 对前i个数字进行了j次操作可以减少的最大总值
    //dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] + nums2[i-1]*i+nums1[i-1])
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int[][] nums = new int[nums1.size()][2];
        int[][] dp = new int[nums1.size()+1][nums1.size()+1];
        int count = 0;
        int sum1 = 0;//nums1总值
        int sum2 = 0;//nums2总值
        int n = nums.length;
        for(int i = 0;i<n;++i){
            nums[i][0] = nums1.indexOf(i);
            nums[i][1] = nums2.indexOf(i);
            sum1+=nums[i][0];
            sum2+=nums[i][1];
        }
        for(int i = 1;i<=n;++i){
            int b = nums[i- 1][0], a = nums[i - 1][1];
            for (int j = i; j > 0; --j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + j * b + a);
            }
        }
        Arrays.sort(nums, (o1,o2)->o1[1] - o2[1]);
        for(int i = 0;i<=n;++i){
            if(sum1+sum2*i-dp[n][i]<=x)
                return i;
            
        }
        return -1;
    }
}
// @lc code=end

