package main

import "unicode"

/*
 * @lc app=leetcode.cn id=3174 lang=golang
 *
 * [3174] 清除数字
 */

// @lc code=start
// 必然有等量的字母在数组右侧
func clearDigits(s string) string {
	ans := []byte{}
	for _, c := range s {
		if !unicode.IsDigit(c) {
			ans = append(ans, byte(c))
		} else {
			ans = ans[:len(ans)-1]
		}
	}
	return string(ans)
}

// @lc code=end
