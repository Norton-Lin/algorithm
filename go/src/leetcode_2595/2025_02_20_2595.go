package main

/*
 * @lc app=leetcode.cn id=2595 lang=golang
 *
 * [2595] 奇偶位数
 */

// @lc code=start
func evenOddBit(n int) []int {
	ans := make([]int, 2)
	index := 0
	for n > 0 {
		if n&1 == 1 {
			ans[index%2]++
		}
		n >>= 1
		index++
	}
	return ans
}

// @lc code=end
