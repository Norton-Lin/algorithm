package main

import (
	"slices"
	"sort"
)

/*
 * @lc app=leetcode.cn id=2616 lang=golang
 *
 * [2616] 最小化数对的最大差值
 */

// @lc code=start
// 选择p个数对，数对的最大差值最小
// 相邻的差值必然尽可能小
// 贪心 + 二分
func MinimizeMax(nums []int, p int) int {
	slices.Sort(nums)
	n := len(nums)
	return sort.Search(nums[n-1]-nums[0], func(mx int) bool {
		cnt := 0
		for i := 0; i < n-1; i++ {
			if nums[i+1]-nums[i] <= mx { // 选 nums[i] 和 nums[i+1]
				cnt++
				i++
			}
		}
		return cnt >= p
	})
}

// @lc code=end
