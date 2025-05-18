package contest450

import (
	"slices"
)

func minSwaps(nums []int) int {
	n := len(nums)
	ans := 0
	sortNums := make([]int, n)
	copy(sortNums, nums)
	slices.SortFunc(sortNums, func(a, b int) int {
		cnt1 := 0
		cnt2 := 0
		tmpa, tmpb := a, b
		for a > 0 {
			cnt1 += a % 10
			a /= 10
		}
		for b > 0 {
			cnt2 += b % 10
			b /= 10
		}
		if cnt1 == cnt2 {
			return tmpa - tmpb
		}
		return cnt1 - cnt2
	})
	records := make(map[int]int)
	for value, key := range nums {
		//记录下标
		records[key] = value
	}
	for i := 0; i < n; i++ {
		if nums[i] != sortNums[i] {
			ans++
			cur := nums[i]
			nums[i] = sortNums[i]
			index := records[nums[i]]
			nums[index] = cur
		}
	}
	return ans
}
