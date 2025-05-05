package main

/*
 * @lc app=leetcode.cn id=790 lang=golang
 *
 * [790] 多米诺和托米诺平铺
 */

// @lc code=start
// 一般递归会超时
// 记忆化
func NumTilings(n int) int {
	var mod = 1_000_000_000 + 7
	if n <= 2 {
		return n
	}
	records := make([]int, n+1)
	records[1], records[2], records[3] = 1, 2, 5
	for i := 4; i <= n; i++ {
		records[i] = ((2*records[i-1])%mod + records[i-3]) % mod
	}
	return records[n]
}

// @lc code=end
