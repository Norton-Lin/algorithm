package main

/*
 * @lc app=leetcode.cn id=2376 lang=golang
 *
 * [2376] 统计特殊整数
 */

// @lc code=start
func countSpecialNumbers(n int) int {
	ans := 0
	for i := 0; i < n; i++ {
		if isSpecial(i) {
			ans++
		}
	}
	return ans
}

func isSpecial(n int) bool {
	seen := make([]bool, 10)
	for n > 0 {
		cur := n % 10
		n /= 10
		if seen[cur] {
			return false
		} else {
			seen[cur] = true
		}
	}
	return true
}

// @lc code=end
