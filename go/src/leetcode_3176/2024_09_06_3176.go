package main

/*
 * @lc app=leetcode.cn id=3176 lang=golang
 *
 * [3176] 求出最长好子序列 I
 */

// @lc code=start
func maximumLength(nums []int, k int) int {
	record := map[int][]int{}
	ans := make([]int, k+2)
	for _, i := range nums {
		if record[i] == nil {
			record[i] = make([]int, k+1)
		}
		cur := record[i]
		for j := k; j >= 0; j-- {
			cur[j] = max(cur[j], ans[j]) + 1
			ans[j+1] = max(ans[j+1], cur[j])
		}
	}
	return ans[k+1]
}

// @lc code=end
