package main

import "sort"

/*
 * @lc app=leetcode.cn id=368 lang=golang
 *
 * [368] 最大整除子集
 */

// @lc code=start
// 每个数不重复
// 所有数对都可以整除
// 从小到大看
// dp记录以本数字结尾的最长子集长度和上一个数字
// O(n^2)
func LargestDivisibleSubset(nums []int) []int {
	ans := make([]int, 0)
	cur := 0
	length := 1
	dp := make([][]int, len(nums))
	sort.Ints(nums)
	for i, num := range nums {
		dp[i] = make([]int, 2)
		for j := i - 1; j >= 0; j-- {
			if num%nums[j] == 0 {
				if dp[i][1] < dp[j][1]+1 {
					dp[i][1] = dp[j][1] + 1
					dp[i][0] = j
				}
			}
		}
	}
	for i, arr := range dp {
		if arr[1] > length {
			length = arr[0]
			cur = i
		}
	}
	for ; cur >= 0; cur = dp[cur][0] {
		ans = append(ans, nums[cur])
	}
	return ans
}

// @lc code=end
