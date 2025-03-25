package main

/*
 * @lc app=leetcode.cn id=2711 lang=golang
 *
 * [2711] 对角线上不同值的数量差
 */

// @lc code=start
// 当前 O(m*n*max(m,m))
// 或者前缀和O(m*n)
func differenceOfDistinctValues(grid [][]int) [][]int {
	m := len(grid)
	n := len(grid[0])
	ans := make([][]int, m)
	record := make(map[int]bool)
	for i := 0; i < m; i++ {
		ans[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			left, right := 0, 0
			for k := 1; j-k >= 0 && i-k >= 0; k++ {
				record[grid[i-k][j-k]] = true
			}
			left = len(record)
			record = make(map[int]bool)
			for k := 1; j+k < n && i+k < m; k++ {
				record[grid[i+k][j+k]] = true
			}
			right = len(record)
			record = make(map[int]bool)
			if left > right {
				ans[i][j] = left - right
			} else {
				ans[i][j] = right - left
			}
		}
	}
	return ans
}

// @lc code=end
