package main

/*
 * @lc app=leetcode.cn id=3222 lang=golang
 *
 * [3222] 求出硬币游戏的赢家
 */

// @lc code=start
func LosingPlayer(x int, y int) string {
	y = y / 4
	ans := ""
	if min(x, y)%2 == 1 {
		ans = "Alice"
	} else {
		ans = "Bob"
	}
	return ans
}

// @lc code=end
