package main

/*
 * @lc app=leetcode.cn id=3248 lang=golang
 *
 * [3248] 矩阵中的蛇
 */

// @lc code=start
func FinalPositionOfSnake(n int, commands []string) int {
	i, j := 0, 0
	for _, command := range commands {
		switch command {
		case "UP":
			i--
		case "DOWN":
			i++
		case "LEFT":
			j--
		case "RIHGT":
			j++
		}
	}
	return i*n + j
}

// @lc code=end
