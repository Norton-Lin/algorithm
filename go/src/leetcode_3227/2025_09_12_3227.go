package main

/*
 * @lc app=leetcode.cn id=3227 lang=golang
 *
 * [3227] 字符串元音游戏
 */

// @lc code=start
func DoesAliceWin(s string) bool {
	for _, c := range s {
		if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
			return true
		}
	}
	return false
}

// @lc code=end
