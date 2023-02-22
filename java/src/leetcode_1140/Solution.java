package leetcode_1140;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //每个人可拿 X = 1-2M堆
    // M = max(M,X)
    //双方都要最优
    //记忆化搜索
    //piles长度为n
    //dp(i,m)表示前i堆被取走，当M=m时，接下去取石头的玩家可以比另一方多取的石头数。
    //当i == n，无石头可取，其他情况下，需要遍历当前玩家取 x =1∼2m 堆石头，
    //并减去对方玩家多取的石头数，挑选出最大值来作为最优策略，从而进行状态转移，
    //dp(i,m) = max(piles[i]+...+piles[i+x-1] - dp[i+x,max(x,m)])
    //用前缀和降低时间复杂度
    /*public int stoneGameII(int[] piles) {
        int[] prefixSum = new int[piles.length + 1];
        for (int i = 0; i < piles.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return (prefixSum[piles.length] + dp(memo, piles, prefixSum, 0, 1)) / 2;
    }

    public int dp(Map<Integer, Integer> memo, int[] piles, int[] prefixSum, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        int key = i * 201 + m;
        if (!memo.containsKey(key)) {
            int maxVal = Integer.MIN_VALUE;
            for (int x = 1; x <= 2 * m; x++) {
                if (i + x > piles.length) {
                    break;
                }
                maxVal = Math.max(maxVal, prefixSum[i + x] - prefixSum[i] - dp(memo, piles, prefixSum, i + x, Math.max(m, x)));
            }
            memo.put(key, maxVal);
        }
        return memo.get(key);
    }*/
	//优化
	//dp[i][j]表示剩余[i : len - 1]堆时，M = j的情况下，先取的人能获得的最多石子数
	/*
	 * i + 2M >= len, dp[i][M] = sum[i : len - 1], 
	 * 剩下的堆数能够直接全部取走，那么最优的情况就是剩下的石子总和
	 * i + 2M < len, 
	 * dp[i][M] = max(dp[i][M], sum[i : len - 1] - dp[i + x][max(M, x)]), 
	 * 其中 1 <= x <= 2M，剩下的堆数不能全部取走，那么最优情况就是让下一个人取的更少。
	 * 对于我所有的x取值，下一个人从x开始取起，M变为max(M, x)，
	 * 所以下一个人能取dp[i + x][max(M, x)]，我最多能取
	 * sum[i : len - 1] - dp[i + x][max(M, x)]。
	 */
	 public int stoneGameII(int[] piles) {
	        int len = piles.length, sum = 0;
	        int[][] dp = new int[len][len + 1];
	        for (int i = len - 1; i >= 0; i--) {
	            sum += piles[i];
	            for (int M = 1; M <= len; M++) {
	                if (i + 2 * M >= len) {
	                    dp[i][M] = sum;
	                }   else {
	                    for (int x = 1; x <= 2 * M; x++) {
	                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
	                    }
	                }
	            }
	        }
	        return dp[0][1];
	    }
    
}