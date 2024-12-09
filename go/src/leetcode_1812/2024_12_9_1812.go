package main

/*
 * @lc app=leetcode.cn id=1812 lang=golang
 *
 * [1812] 判断国际象棋棋盘中一个格子的颜色
 */

// @lc code=start
func SquareIsWhite(coordinates string) bool {
	return (coordinates[0]+coordinates[1])%2 == 1
}

// @lc code=end
