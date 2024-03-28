package day.leetcode_1997;
/*
 * @lc app=leetcode.cn id=1997 lang=java
 *
 * [1997] 访问完所有房间的第一天
 */
// @lc code=start
class Solution {
    //dp
    //next一定小于当前i
    //i+1 一定是 第二次到i后+1
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        
        int mod = 1000000007;
        int n = nextVisit.length;
        int[] dp = new int[n];
        dp[0] = 0; dp[1] = 2;
        for(int i = 2;i < n;i++){
            //dp[i - 1] - dp[nextVisit[i-1]] 第二次到i差值
            int temp = dp[i-1] + dp[i - 1] - dp[nextVisit[i-1]] + 2;
            if(temp < 0) temp += mod;//2*dp[i-1]可能越界
            dp[i] = temp % mod;
        }
        
        return dp[n - 1];
    }
}
// @lc code=end

