/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子等于目标和的方法数
 */

// @lc code=start
class Solution {
    // n个k面骰子
    // 求k^n次方中可能中，和为target的次数
    // 爆搜剪枝 不可能 30^30次方 搜个鬼
    // dp 01背包
    public static int mod = 1000000007;
    /**
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i = 1;i<dp.length;++i)
        {
            for(int j = 1;j<dp[i].length;++j){
                for(int l = 1;l<=k;++l){
                    if(j-l<0)
                        break;
                    dp[i][j] += dp[i-1][j-l];
                    dp[i][j]%=mod;
                }
            }
        }
        return dp[n][target];
    } */
    /** 
     * 双数组优化
    public int numRollsToTarget(int n, int k, int target){
        int dp[] = new int[target+1];
        int cur[] = new int[target+1];
        dp[0] = 1;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<dp.length;++j){
                cur[j] = dp[j];
                dp[j] = 0;
                for(int l = 1;j-l>=0&&l<=k;++l){
                    dp[j] = (dp[j] + cur[j-l])%mod;
                }
            }
        }
        return dp[target];
    }*/
    //还能降
    public int numRollsToTarget(int n, int k, int target){
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 0;i<n;++i){
            for(int j = target;j>=0;--j){
                for(int l = 1;j-l>=0&&l<=k;--l)
                    dp[j] += dp[j-l];
            }
        }
        return dp[target];
    }
    /**
     * 大佬的进一步优化版本
     * public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) {
            return 0; // 无法组成 target
        }
        final int MOD = 1_000_000_007;
        long[] f = new long[target - n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int mx = Math.min(i * (k - 1), target - n); // i 个骰子至多掷出 i*(k-1)
            for (int j = 1; j <= mx; j++) {
                f[j] += f[j - 1]; // 原地计算 f 的前缀和
            }
            for (int j = mx; j >= k; j--) {
                f[j] = (f[j] - f[j - k]) % MOD; // f[j] 是两个前缀和的差
            }
        }
        return (int) f[target - n];
    }
     * 
     */
}
// @lc code=end
