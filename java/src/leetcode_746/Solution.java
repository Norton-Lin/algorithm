/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */
package leetcode_746;
// @lc code=start
class Solution {
    //每次爬一到两个台阶
    //dp
    //dp[i] = max(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    public int minCostClimbingStairs(int[] cost) {
        int ans = 0;
        int dp1 = 0;
        int dp2 = 0;
        for(int i = 2;i<cost.length;++i){
            ans = Math.max(dp1+cost[i-2],dp2+cost[i-1]);
            dp1 = dp2;
            dp2 = ans;
        }
        return ans;
    }
}
// @lc code=end

