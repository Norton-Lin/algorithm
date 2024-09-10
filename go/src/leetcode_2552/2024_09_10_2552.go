package main

import "slices"

/*
 * @lc app=leetcode.cn id=2552 lang=golang
 *
 * [2552] 统计上升四元组
 */

// @lc code=start
// less[j][x] 表示在j左边且小于x = nums[k]的值的数量 即 i
// great[k][x] 表示在k右边且大于x = nums[j]的值的数量 即 l
// O(n^2)
func countQuadruplets(nums []int) int64 {
	var ans int64 = 0
	n := len(nums)
	great := make([][]int, n)
	great[n-1] = make([]int, n+1) //记录1-n
	for k := n - 2; k >= 2; k-- {
		great[k] = slices.Clone(great[k+1])
		for x := 1; x < nums[k+1]; x++ { //在k右边，大于x的 因为nums[k+1]>x
			great[k][x]++
		}
	}
	less := make([]int, n+1)
	for j := 1; j < n-2; j++ {
		for x := n; x > nums[j-1]; x-- { //j左边，小于x 应为nums[j-1]<x
			less[x]++
		}
		//枚举 j , k
		for k := j + 1; k < n-1; k++ {
			if nums[j] > nums[k] {
				ans += int64(less[nums[k]] * great[k][nums[j]])
			}
		}
	}
	return ans
}

// @lc code=end
