package main

/*
 * @lc app=leetcode.cn id=2643 lang=golang
 *
 * [2643] 一最多的行
 */

// @lc code=start
func RowAndMaximumOnes(mat [][]int) []int {
	ans := make([]int, 2)
	for index, line := range mat {
		cur := 0
		for _, num := range line {
			if num == 1 {
				cur++
			}
		}
		if cur > ans[1] {
			ans[1] = cur
			ans[0] = index
		}
	}
	return ans
}

// @lc code=end
