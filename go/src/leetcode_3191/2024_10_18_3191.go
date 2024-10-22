package main

/*
 * @lc app=leetcode.cn id=3191 lang=golang
 *
 * [3191] 使二进制数组全部等于 1 的最少操作次数 I
 */

// @lc code=start
// 贪心即可
func MinOperations(nums []int) int {
	n := len(nums)
	ans := 0
	for i := 0; i < n-2; i++ {
		if nums[i] == 0 {
			nums[i] = 1
			nums[i+1] = (nums[i+1] + 1) % 2
			nums[i+2] = (nums[i+2] + 1) % 2
			ans++
		}
	}
	if nums[n-1] == 0 || nums[n-2] == 0 {
		ans = -1
	}
	return ans
}

// @lc code=end
