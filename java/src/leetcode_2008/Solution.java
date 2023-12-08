/*
 * @lc app=leetcode.cn id=2008 lang=java
 *
 * [2008] 出租车的最大盈利
 */

// @lc code=start
package leetcode_2008;
import java.util.Arrays;

class Solution {
    //地点 1 - n
    //0-1背包
    //路程是容积，盈利 = 路程 + 小费 是利润
    //rides表示移动位置和利润
    //dp[i] 表示到i位置时的最大利润
    //dp[i] 若有人下车 为 dp[start] + (end-start+tip)
    //没人下车 即为 dp[i] = dp[i-1]
    public long maxTaxiEarnings(int n, int[][] rides) {
        long dp[] = new long[n+1];
        int index = 0;
        Arrays.sort(rides,(a,b)->a[1]-b[1]);//根据end排列
        for(int i = 1;i<=n;++i){
            while(index<rides.length&&rides[index][1]<i){
                ++index;
            }
            while(index<rides.length&&rides[index][1]==i){
                dp[i] = Math.max(dp[i],dp[rides[index][0]]+rides[index][1]-rides[index][0]+rides[index][2]);
                ++index;
            }
            dp[i] = Math.max(dp[i],dp[i-1]);
        }
        return dp[n];
    }
    /**
     * 优化
    public long maxTaxiEarnings(int n, int[][] rides){
        public long maxTaxiEarnings(int n, int[][] rides) {
            long[] dp = new long[n + 1];
            Arrays.sort(rides, (a, b) -> a[1] - b[1]);
            int i = 0;
            for(int[] ride : rides){
                while(i < ride[1]){
                    dp[i + 1] = dp[i++];
                }
                dp[i] = Math.max(dp[i] , dp[ride[0]] + ride[1] - ride[0] + ride[2]);
            }
            return dp[i];
        }
    }
     */
    
    public static void main(String args[]){
        Solution s = new Solution();
        s.maxTaxiEarnings(20, new int[][]{{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}});
    }
}
// @lc code=end

