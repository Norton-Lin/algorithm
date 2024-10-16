package main

import "sort"

/*
 * @lc app=leetcode.cn id=3194 lang=golang
 *
 * [3194] 最小元素和最大元素的最小平均值
 */

// @lc code=start
func MinimumAverage(nums []int) float64 {
	sort.Ints(nums)
	n := len(nums)
	ans := float64(nums[n-1])
	for i := 0; i < n/2; i++ {
		ans = min(float64(nums[i]+nums[n-1-i])/2, ans)
	}
	return ans
}

// @lc code=end
