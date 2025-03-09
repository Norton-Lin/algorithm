package main

/*
 * @lc app=leetcode.cn id=1014 lang=golang
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
func maxScoreSightseeingPair(values []int) int {
	ans := values[0] + values[1] - 1
	cur := ans
	n := len(values)
	for i := 2; i < n; i++ {
		cur = max(cur+values[i]-values[i-1]-1, values[i]+values[i-1]-1)
		ans = max(cur, ans)
	}
	return ans
}

// @lc code=end
