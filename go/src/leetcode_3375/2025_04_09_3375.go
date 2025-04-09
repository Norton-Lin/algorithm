package main

import "sort"

// 每次选择h 每次操作，可以把大于 h的数变成h
// h的限制为，当前数组中，所有大于h的数都相等
// 每次选择的h是第二大的数
// 最后把所有的数变成k
// 排序 或者 每次记录这个数是否用过 空间换时间
func MinOperations(nums []int, k int) int {
	ans := 0
	sort.Ints(nums)
	if nums[0] < k {
		return -1
	}
	for _, num := range nums {
		if num > k {
			k = num
			ans++
		}
	}
	return ans
}
