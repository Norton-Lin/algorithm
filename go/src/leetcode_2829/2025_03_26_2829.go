package main

/*
 * @lc app=leetcode.cn id=2829 lang=golang
 *
 * [2829] k-avoiding 数组的最小总和
 */

// @lc code=start
// 哈希记录
// 数组优化 + 数学计算
func MinimumSum(n int, k int) int {
	ans := 0
	record := make([]bool, k)
	for i := 1; n > 0; i++ {
		if i >= k {
			ans += (k + n + k - 1) * n / 2
			break
		} else if !record[k-i] {
			record[i] = true
			ans += i
			n--
		}
	}
	return ans
}

// @lc code=end
