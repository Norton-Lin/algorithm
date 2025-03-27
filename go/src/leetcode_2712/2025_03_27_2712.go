package main

/*
 * @lc app=leetcode.cn id=2712 lang=golang
 *
 * [2712] 使所有字符相等的最小成本
 */

// @lc code=start
func MinimumCost(s string) int64 {
	ans := int64(0)
	n := len(s)
	for i := 1; i < n; i++ {
		if s[i] != s[i-1] {
			ans += int64(min(i, n-i))
		}
	}
	return ans
}

// @lc code=end
