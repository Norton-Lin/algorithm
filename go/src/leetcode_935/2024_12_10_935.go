package main

/*
 * @lc app=leetcode.cn id=935 lang=golang
 *
 * [935] 骑士拨号器
 */

// @lc code=start
// 1 3 7 9 可以跳到2 4 6 8 各有两种可能
// 2 8 可以跳到1 3 7 9 各有两种可能
// 4 6 可以跳到1 3 7 9 0 各有三种可能
// 5是终态，没有下一阶段
// dp[0] = dp[4] + dp[6]
// dp[1] = dp[8] + dp[6]
// dp[2] = dp[7] + dp[9]
// dp[3] = dp[4] + dp[8]
// dp[4] = dp[0] + dp[3]+ dp[9]
// dp[5] = 0
// dp[6] = dp[0] + dp[1]+ dp[7]
// dp[7] = dp[2] + dp[6]
// dp[8] = dp[1] + dp[3]
// dp[9] = dp[2] + dp[4]
func KnightDialer(n int) int {
	const mod int64 = 1e9 + 7
	dp := make([]int64, 10)
	cur := make([]int64, 10)
	ans := 0
	for i := 0; i < 10; i++ {
		dp[i] = 1
	}
	for i := 1; i < n; i++ {
		copy(cur, dp)
		dp[0] = (cur[4] + cur[6]) % mod
		dp[1] = (cur[8] + cur[6]) % mod
		dp[2] = (cur[7] + cur[9]) % mod
		dp[3] = (cur[4] + cur[8]) % mod
		dp[4] = (cur[0] + cur[3] + cur[9]) % mod
		dp[5] = 0
		dp[6] = (cur[0] + cur[1] + cur[7]) % mod
		dp[7] = (cur[2] + cur[6]) % mod
		dp[8] = (cur[1] + cur[3]) % mod
		dp[9] = (cur[2] + cur[4]) % mod
	}
	for i := 0; i < 10; i++ {
		ans = (ans + int(dp[i])) % int(mod)
	}
	return ans
}

// @lc code=end
