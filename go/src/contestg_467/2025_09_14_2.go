package main

import (
	"sort"
)

func maxKDistinct(nums []int, k int) []int {
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] > nums[j]
	})
	pre := nums[0]
	ans := make([]int, 0)
	ans = append(ans, pre)
	for i := 1; i < len(nums) && k > 1; i++ {
		if nums[i] == pre {
			continue
		}
		k--
		ans = append(ans, nums[i])
	}
	return ans
}
