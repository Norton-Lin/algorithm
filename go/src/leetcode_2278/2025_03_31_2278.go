package main

/*
 * @lc app=leetcode.cn id=2278 lang=golang
 *
 * [2278] 字母在字符串中的百分比
 */

// @lc code=start
func PercentageLetter(s string, letter byte) int {
	num := 0
	ans := 0
	for _, c := range []byte(s) {
		if c == letter {
			num++
		}
	}
	ans = (num * 100) / len(s)
	return ans
}

// @lc code=end
