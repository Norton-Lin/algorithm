package main

/*
 * @lc app=leetcode.cn id=52 lang=golang
 *
 * [52] N 皇后 II
 */

// @lc code=start
func TotalNQueens(n int) int {
	ans := 0
	record := make([][]int, n)
	for i := 0; i < n; i++ {
		record[i] = make([]int, n)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			record[i][j] = 0
		}
	}
	var dfs func(record [][]int, l int)
	dfs = func(record [][]int, l int) {
		n := len(record)
		if l == n {
			ans++
			return
		}
		for j := 0; j < n; j++ {
			record[l][j] = 1
			if j > 0 {
				record[l][j-1] = 0
			}
			if isValid(record, l, j) {
				dfs(record, l+1)
			}
		}
		record[l][n-1] = 0
	}
	dfs(record, 0)
	return ans
}
func isValid(record [][]int, l int, k int) bool {
	j := 1

	for i := l - 1; i >= 0; i-- {
		if record[i][k] == 1 {
			return false
		}
		if k-j >= 0 && record[i][k-j] == 1 {
			return false
		}
		if k+j < len(record) && record[i][k+j] == 1 {
			return false
		}
		j++
	}
	return true
}

// @lc code=end
