package main

import (
	"sort"
)

/*
 * @lc app=leetcode.cn id=3180 lang=golang
 *
 * [3180] 执行操作可获得的最大总奖励 I
 */

// @lc code=start
// 深搜递归超时
// dp
// sum最大值不可能超过reward最大值一倍
// f := f | ((1<<v)-1)<<v
func MaxTotalReward(rewardValues []int) int {
	sort.Ints(rewardValues)
	n := len(rewardValues)
	dp := make([]int, 2*rewardValues[n-1])
	dp[0] = 1
	for _, x := range rewardValues {
		for k := 2*x - 1; k >= x; k-- {
			if dp[k-x] == 1 {
				dp[k] = 1
			}
		}
	}
	ans := 0
	for i := 1; i < len(dp); i++ {
		if dp[i] == 1 {
			ans = i
		}
	}

	return ans
}

// @lc code=end
