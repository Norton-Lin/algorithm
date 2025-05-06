package main

/*
 * @lc app=leetcode.cn id=1920 lang=golang
 *
 * [1920] 基于排列构建数组
 */

// @lc code=start
func BuildArray(nums []int) []int {
	ans := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		ans[i] = nums[nums[i]]
	}
	return ans
}

// @lc code=end
