package main

import "sort"

/*
 * @lc app=leetcode.cn id=3024 lang=golang
 *
 * [3024] 三角形类型
 */

// @lc code=start
func TriangleType(nums []int) string {
	sort.Ints(nums)
	ans := ""
	if nums[0]+nums[1] <= nums[2] {
		ans = "none"
	} else {
		if nums[0] == nums[1] || nums[1] == nums[2] {
			if nums[0] == nums[2] {
				ans = "equilateral"
			} else {
				ans = "isosceles"
			}
		} else {
			ans = "scalene"
		}
	}
	return ans
}

// @lc code=end
