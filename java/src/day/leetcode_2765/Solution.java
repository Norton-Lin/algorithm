/*
 * @lc app=leetcode.cn id=2765 lang=java
 *
 * [2765] 最长交替子序列
 */

// @lc code=start
class Solution {
    //交替序列长度大于1
    public int alternatingSubarray(int[] nums) {
        int dp[] = new int[nums.length];
        int ans = -1;
        for(int i = 1;i<nums.length;++i){
            if(nums[i] - nums[i-1] == (int)Math.pow(-1,dp[i-1])){
                dp[i] = dp[i-1]+1;
                ans = Math.max(dp[i]+1,ans);
            }
            else if(nums[i] - nums[i-1] == 1)
                dp[i] = 1;
        }
        return ans;
    }
}
// @lc code=end

