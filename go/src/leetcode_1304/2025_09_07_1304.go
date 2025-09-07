package main

/*
 * @lc app=leetcode.cn id=1304 lang=golang
 *
 * [1304] 和为零的 N 个不同整数
 */

// @lc code=start
func SumZero(n int) []int {
	ans := make([]int, n)
	numi, numj := -1, 1
	for i, j := 0, n-1; i < j; i, j = i+1, j-1 {
		ans[i], ans[j] = numi, numj
		numi--
		numj++
	}
	return ans
}

// @lc code=end
