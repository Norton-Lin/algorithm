package main

/*
 * @lc app=leetcode.cn id=3192 lang=golang
 *
 * [3192] 使二进制数组全部等于 1 的最少操作次数 II
 */

// @lc code=start
func MinOperations(nums []int) int {
	ans := 0
	for _, num := range nums {
		if (num+ans)%2 == 0 {
			ans++
		}
	}
	return ans
}

// @lc code=end
