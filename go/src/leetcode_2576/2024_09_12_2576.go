package main

import "sort"

/*
 * @lc app=leetcode.cn id=2576 lang=golang
 *
 * [2576] 求出最多标记下标
 */

// @lc code=start
// i j 都不同，且没用过
// 2 * nums[i] <= nums[j]
// 哈希记录i是否使用过(曾经是j)
// 基于贪心， j直接从中间开始移动，无须考虑重复
// 数组奇偶单独考虑
func MaxNumOfMarkedIndices(nums []int) int {
	sort.Ints(nums)
	n := len(nums)
	ans := 0
	i := 0
	j := n / 2
	if n%2 == 1 { //防止数据重复使用
		j++
	}
	for ; j < n; j++ {
		if nums[i]*2 <= nums[j] {
			ans += 2
			i++
		}
	}
	return ans
}

// @lc code=end
