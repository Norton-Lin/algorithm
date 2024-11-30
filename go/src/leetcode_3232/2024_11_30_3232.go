package main

/*
 * @lc app=leetcode.cn id=3232 lang=golang
 *
 * [3232] 判断是否可以赢得数字游戏
 */

// @lc code=start
func CanAliceWin(nums []int) bool {
	value := 0
	sum := 0
	for _, num := range nums {
		if num < 10 {
			value += num
		}
		sum += num
	}
	return sum-value != value
}

// @lc code=end
