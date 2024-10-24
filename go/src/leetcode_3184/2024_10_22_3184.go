package main

/*
 * @lc app=leetcode.cn id=3184 lang=golang
 *
 * [3184] 构成整天的下标对数目 I
 */

// @lc code=start
// 优化考虑用哈希
func CountCompleteDayPairs(hours []int) int {
	ans := 0
	n := len(hours)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if (hours[i]+hours[j])%24 == 0 {
				ans++
			}
		}
	}
	return ans
}

// @lc code=end
