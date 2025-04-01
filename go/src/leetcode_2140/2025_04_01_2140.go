package main

/*
 * @lc app=leetcode.cn id=2140 lang=golang
 *
 * [2140] 解决智力问题
 */

// @lc code=start
// dp 动态规划
// 解决 i问题能获得的最高分数
// 解决 i ， max(pre) + questions[i][0] pre不能阻碍i
// 不解决i， max(pre) pre没有限制
// 从后往前dp,拿与不拿
// dp[i+1] 不拿当前，questions[i][0]只拿当前
// dp[i] = max(dp[i+1],questions[i][0],dp[i+question[i][1]]+questions[i][0])
func MostPoints(questions [][]int) int64 {
	n := len(questions)
	dp := make([]int64, n+1)
	dp[n] = 0
	for i := n - 1; i >= 0; i-- {
		dp[i] = max(int64(questions[i][0]), dp[i+1])
		if i+questions[i][1] < n {
			dp[i] = max(dp[i], dp[i+questions[i][1]+1]+int64(questions[i][0]))
		}
	}
	return dp[0]
}

// @lc code=end
