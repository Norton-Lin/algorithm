package main

/*
 * @lc app=leetcode.cn id=118 lang=golang
 *
 * [118] 杨辉三角
 */

// @lc code=start
func Generate(numRows int) [][]int {
	ans := make([][]int, 0)
	ans = append(ans, []int{1})
	for i := 1; i < numRows; i++ {
		cur := make([]int, 0)
		cur = append(cur, 1)
		for j := 1; j < i; j++ {
			cur = append(cur, ans[i-1][j]+ans[i-1][j-1])
		}
		cur = append(cur, 1)
		ans = append(ans, cur)
	}
	return ans
}

// @lc code=end
