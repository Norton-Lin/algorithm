package main

import (
	"strings"
)

/*
 * @lc app=leetcode.cn id=51 lang=golang
 *
 * [51] N 皇后
 */

// @lc code=start
func SolveNQueens(n int) [][]string {
	ans := make([][]string, 0)
	var dfs func(n int, cur []string, p int)
	dfs = func(n int, cur []string, p int) {
		if !isValid(n, cur, p) {
			return
		}
		index := len(cur)
		if index == n {
			dst := make([]string, len(cur))
			copy(dst, cur)
			ans = append(ans, dst)
			return
		}
		next := []rune(strings.Repeat(".", n))
		for i := 0; i < n; i++ {
			next[i] = 'Q'
			if i > 0 {
				next[i-1] = '.'
				cur = cur[:len(cur)-1]
			}
			cur = append(cur, string(next))
			dfs(n, cur, i)
		}
	}
	dfs(n, make([]string, 0), 0)
	return ans
}

func isValid(n int, cur []string, p int) bool {
	index := len(cur)
	j := 1
	for i := index - 2; i >= 0; i-- {
		if cur[i][p] == 'Q' {
			return false
		}
		if p-j >= 0 && cur[i][p-j] == 'Q' {
			return false
		}
		if p+j < n && cur[i][p+j] == 'Q' {
			return false
		}
		j++
	}
	return true
}

// @lc code=end
