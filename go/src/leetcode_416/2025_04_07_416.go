package main

import "sort"

/*
 * @lc app=leetcode.cn id=416 lang=golang
 *
 * [416] 分割等和子集
 */

// @lc code=start
// 0 1 背包？
// dfs吧 超时
// dp[i][j] 0-i个数范围内，可以凑出j
// dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]] j >= nums[i]
//
//	= dp[i-1][j] j< nums[i]
func CanPartition(nums []int) bool {
	sum := 0
	n := len(nums)
	ans := false
	for _, num := range nums {
		sum += num
	}
	if sum%2 == 1 {
		return ans
	}
	sum /= 2
	dp := make([][]bool, n)
	sort.Ints(nums)
	for i := 0; i < n; i++ {
		dp[i] = make([]bool, sum+1)
	}
	if nums[0] > sum {
		return false
	}
	dp[0][nums[0]] = true
	for i := 1; i < n; i++ {
		for j := 0; j <= sum; j++ {
			dp[i][j] = dp[i-1][j]
			if j >= nums[i] {
				dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]]
			}
		}
	}
	return dp[n-1][sum]
}

// @lc code=end
