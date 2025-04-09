package main

/*
 * @lc app=leetcode.cn id=1863 lang=golang
 *
 * [1863] 找出所有子集的异或总和再求和
 */

// @lc code=start
// 深搜找子集，求和
func SubsetXORSum(nums []int) int {
	n := len(nums)
	ans := 0
	var dfs func(nums []int, start, count, cur int)
	dfs = func(nums []int, start, count, cur int) {
		if count == 0 {
			ans += cur
			return
		}
		if start >= n {
			return
		}
		for i := start; i < n; i++ {
			dfs(nums, i+1, count-1, cur^nums[i])
		}
	}
	for i := 1; i <= n; i++ {
		dfs(nums, 0, i, 0)
	}
	return ans

}

// @lc code=end
