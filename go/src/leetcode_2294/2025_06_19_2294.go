package main

import "sort"

/*
 * @lc app=leetcode.cn id=2294 lang=golang
 *
 * [2294] 划分数组使最大差为 K
 */

// @lc code=start
// 若落入序列区间，就不需要新开一个序列
// 还是可以排序
func PartitionArray(nums []int, k int) int {
	ans := 1
	sort.Ints(nums)
	cur := nums[0]
	for _, num := range nums {
		//fmt.Println(cur,num)
		if num-cur > k {
			ans++
			cur = num
		}

	}
	return ans
}

// @lc code=end
