package main

/*
 * @lc app=leetcode.cn id=3208 lang=golang
 *
 * [3208] 交替组 II
 */

// @lc code=start
// dp 到i为止，连续dpi个数交替
func NumberOfAlternatingGroups(colors []int, k int) int {
	n := len(colors)
	dp := make([]int, n)
	ans := 0
	for i := 0; i < n; i++ {
		dp[i] = 1
	}
	for i := n - k; i < n; i++ { //取模防止越界
		if colors[i] != colors[(n+i-1)%n] {
			dp[i] = dp[(n+i-1)%n] + 1
		}
	}
	for i := 0; i < n; i++ {
		if colors[i] != colors[(n+i-1)%n] {
			dp[i] = dp[(n+i-1)%n] + 1
		} else {
			dp[i] = 1
		}
		if dp[i] >= k {
			ans++
		}
	}
	return ans
}

// @lc code=end
