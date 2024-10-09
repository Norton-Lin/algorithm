package main

import "math"

/*
 * @lc app=leetcode.cn id=3171 lang=golang
 *
 * [3171] 找到按位或最接近 K 的子数组
 */

// @lc code=start
func MinimumDifference(nums []int, k int) int {
	ans := math.MaxInt
	var left, bottom, rightOr int
	for right, x := range nums {
		rightOr |= x
		for left <= right && nums[left]|rightOr > k {
			ans = min(ans, (nums[left]|rightOr)-k)
			left++
			if bottom < left {
				// 重新构建一个栈
				for i := right - 1; i >= left; i-- {
					nums[i] |= nums[i+1]
				}
				bottom = right
				rightOr = 0
			}
		}
		if left <= right {
			ans = min(ans, k-(nums[left]|rightOr))
		}
	}
	return ans
}

// @lc code=end
