package main

/*
 * @lc app=leetcode.cn id=3175 lang=golang
 *
 * [3175] 找到连续赢 K 场比赛的第一位玩家
 */

// @lc code=start
// 一定有解
func findWinningPlayer(skills []int, k int) int {
	cur := 0
	ans := 0
	n := len(skills)
	if k >= n {
		k = k%(n-1) + n - 1
	}
	for i := 1; cur < k && i < n; i++ {
		if skills[ans] < skills[i] {
			cur = 1
			ans = i
		} else {
			cur++
		}
	}
	return ans
}

// @lc code=end
