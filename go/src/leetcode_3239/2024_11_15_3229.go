package main

/*
 * @lc app=leetcode.cn id=3239 lang=golang
 *
 * [3239] 最少翻转次数使二进制矩阵回文 I
 */

// @lc code=start
func minFlips(grid [][]int) int {
	ans1, ans2 := 0, 0
	n, m := len(grid), len(grid[0])
	for i := 0; i < n; i++ {
		j, k := 0, m-1
		for j < k {
			if grid[i][j] != grid[i][k] {
				ans1++
			}
			j++
			k--
		}
	}
	for i := 0; i < m; i++ {
		j, k := 0, n-1
		for j < k {
			if grid[j][i] != grid[k][i] {
				ans2++
			}
			j++
			k--
		}
	}
	return min(ans1, ans2)
}

// @lc code=end
