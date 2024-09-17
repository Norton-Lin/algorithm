package main

import "sort"

/*
 * @lc app=leetcode.cn id=2860 lang=golang
 *
 * [2860] 让所有学生保持开心的分组方法数
 */

// @lc code=start
// 有i 人数大于nums[i] 不能等于
// 没有i 人数小于nums[i]
// 每次选少人
func CountWays(nums []int) int {
	n := len(nums)
	sort.Ints(nums)
	ans := 0
	// 不选
	if nums[0] > 0 {
		ans++
	}
	// 讨论1 - n 个
	for i := 0; i < n; i++ {
		// 当前位选中看严格大于 后一位没选中看严格小于
		if nums[i] < i+1 && (i == n-1 || nums[i+1] > i+1) {
			ans++
		}
	}
	return ans
}

// @lc code=end
