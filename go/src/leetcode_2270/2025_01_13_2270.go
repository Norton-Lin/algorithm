package main

/*
 * @lc app=leetcode.cn id=2270 lang=golang
 *
 * [2270] 分割数组的方案数
 */

// @lc code=start
func WaysToSplitArray(nums []int) int {
	num1, num2 := 0, 0
	ans := 0
	n := len(nums)
	for _, num := range nums {
		num2 += num
	}
	for i := 0; i < n-1; i++ {
		num1 += nums[i]
		num2 -= nums[i]
		if num1 >= num2 {
			ans++
		}
	}
	return ans
}

// @lc code=end
