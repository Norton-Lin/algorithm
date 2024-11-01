package main

/*
 * @lc app=leetcode.cn id=3259 lang=golang
 *
 * [3259] 超级饮料的最大强化能量
 */

// @lc code=start
// dp
func MaxEnergyBoost(energyDrinkA []int, energyDrinkB []int) int64 {
	n := len(energyDrinkA)
	dp := make([][]int64, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int64, 2)
	}
	dp[0][0] = int64(energyDrinkA[0])
	dp[0][1] = int64(energyDrinkB[0])
	dp[1][0] = max(dp[0][0]+int64(energyDrinkA[1]), dp[0][1])
	dp[1][1] = max(dp[0][1]+int64(energyDrinkB[1]), dp[0][0])
	for i := 2; i < n; i++ {
		dp[i][0] = max(dp[i-1][0]+int64(energyDrinkA[i]), dp[i-1][1])
		dp[i][1] = max(dp[i-1][1]+int64(energyDrinkB[i]), dp[i-1][0])
	}
	return max(dp[n-1][0], dp[n-1][1])
}

// @lc code=end
