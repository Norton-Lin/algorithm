package main

import "sort"

/*
 * @lc app=leetcode.cn id=910 lang=golang
 *
 * [910] 最小差值 II
 */

// @lc code=start
func SmallestRangeII(nums []int, k int) int {
	sort.Ints(nums)
	n := len(nums)
	ans := nums[n-1] - nums[0] // 都变大、变小
	//然后大的变小小的变大
	for i := 1; i < n; i++ {
		mx := max(nums[n-1]-k, nums[i-1]+k)
		mn := min(nums[0]+k, nums[i]-k)
		ans = min(ans, mx-mn)

	}
	return ans
}

// @lc code=end
