package main

/*
 * @lc app=leetcode.cn id=3250 lang=golang
 *
 * [3250] 单调数组对的数目 I
 */

// @lc code=start
const mod int = 1e9 + 7

func CountOfPairs(nums []int) int {
	n := len(nums)
	ans := 0
	dp := make([][]int, n+1)
	for i := 1; i <= n; i++ {
		dp[i] = make([]int, nums[i-1]+1)
	}
	for s := 0; s <= nums[0]; s++ {
		dp[1][s] = 1
	}
	for i := 2; i <= n; i++ {
		//记录每一个dp[i][s]
		for s := 0; s <= nums[i-1]; s++ {
			for j := 0; j <= s; j++ {
				if nums[i-2]-j >= nums[i-1]-s {
					dp[i][s] = (dp[i][s] + dp[i-1][j]) % mod
				}
			}
		}
	}
	for s := 0; s <= nums[n-1]; s++ {
		ans = (ans + dp[n][s]) % mod
	}
	return ans
}

// @lc code=end
