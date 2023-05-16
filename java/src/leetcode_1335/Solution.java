package leetcode_1335;

import java.util.Arrays;
class Solution {
    //d天
    //要执行工作i，必须完成全部j项工作，0<=j<i
    //每天至少一项，每天的工作难度是当天完成工作的最大难度
	//dp[i][j] 第i天的第一项工作是第j个工作，i-d天的总工作难度为dp[i][j]
	//分成d个非空区间，每个子区间的最大值的和最小
	//完成前i份工作要j天，最小难度为dp[i][j]
	public int minDifficulty(int[] jobDifficulty, int d) {
        final int inf = 1 << 30;
        int n = jobDifficulty.length;
        int[][] f = new int[n + 1][d + 1];
        for (var g : f) {
            Arrays.fill(g, inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) //第i个工作到第n个工作
        {
            for (int j = 1; j <= Math.min(d, i); ++j) //第i个工作必须在第j天前完成
            {
                int mx = 0;
                for (int k = i; k > 0; --k) //第j天，做完的任务为[k..i]
                {
                    mx = Math.max(mx, jobDifficulty[k - 1]);
                    f[i][j] = Math.min(f[i][j], f[k - 1][j - 1] + mx);
                }
            }
        }
        return f[n][d] >= inf ? -1 : f[n][d];
    }
    public static void main(String args[]) {
		Solution solution = new Solution();
		int ans = solution.minDifficulty(new int[] {7,1,7,1,7,1}, 3);
		System.out.print(ans);
	}
}
