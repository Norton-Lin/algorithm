package main

/*
 * @lc app=leetcode.cn id=2894 lang=golang
 *
 * [2894] 分类求和并作差
 */

// @lc code=start
func DifferenceOfSums(n int, m int) int {
	ans := 0
	for i := 0; i <= n; i++ {
		if i%m != 0 {
			ans += i
		} else {
			ans -= i
		}
	}
	return ans
}

// @lc code=end
