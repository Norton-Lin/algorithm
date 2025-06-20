package main

import "sort"

/*
 * @lc app=leetcode.cn id=2966 lang=golang
 *
 * [2966] 划分数组并满足最大差限制
 */

// @lc code=start
func DivideArray(nums []int, k int) [][]int {
	ans := make([][]int, 0)
	sort.Ints(nums)
	n := len(nums)
	for i := 0; i < n; i += 3 {
		cur := make([]int, 0)
		for j := i; j < i+3; j++ {
			if nums[j]-nums[i] > k {
				return make([][]int, 0)
			}
			cur = append(cur, nums[j])
		}
		ans = append(ans, cur)
	}
	return ans
}

// @lc code=end
