package main

import "sort"

/*
 * @lc app=leetcode.cn id=3397 lang=golang
 *
 * [3397] 执行操作后不同元素的最大数量
 */

// @lc code=start
func MaxDistinctElements(nums []int, k int) int {
	sort.Ints(nums)
	ans := 0
	pre := nums[0] - k
	for _, num := range nums {
		pre = max(num-k, pre)
		if pre > num+k {
			continue
		}
		ans++
		pre++
	}
	return ans
}

// @lc code=end
