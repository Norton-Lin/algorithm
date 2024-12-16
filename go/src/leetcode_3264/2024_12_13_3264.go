package main

/*
 * @lc app=leetcode.cn id=3264 lang=golang
 *
 * [3264] K 次乘运算后的最终数组 I
 */

// @lc code=start
func getFinalState(nums []int, k int, multiplier int) []int {
	for i := 0; i < k; i++ {
		index := 0
		num := nums[index]
		for j := 1; j < len(nums); j++ {
			if num > nums[j] {
				num = nums[j]
				index = j
			}
		}
		nums[index] *= multiplier
	}
	return nums
}

// @lc code=end
