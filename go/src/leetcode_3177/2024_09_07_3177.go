package main

/*
 * @lc app=leetcode.cn id=3177 lang=golang
 *
 * [3177] 求出最长好子序列 II
 */

// @lc code=start
func MaximumLength(nums []int, k int) int {
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
