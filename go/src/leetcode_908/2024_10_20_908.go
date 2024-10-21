package main

import "sort"

/*
 * @lc app=leetcode.cn id=908 lang=golang
 *
 * [908] 最小差值 I
 */

// @lc code=start
func SmallestRangeI(nums []int, k int) int {
	sort.Ints(nums)
	n := len(nums)
	ans := 0
	if nums[n-1]-nums[0] <= 2*k {
		ans = 0
	} else {
		ans = nums[n-1] - nums[0] - 2*k
	}
	return ans
}

// @lc code=end
