package main

/*
 * @lc app=leetcode.cn id=3330 lang=golang
 *
 * [3330] 找到初始输入字符串 I
 */

// @lc code=start
func PossibleStringCount(word string) int {
	ans := 1
	pre := rune(0)
	for _, c := range word {
		if c == pre {
			ans++
		}
		pre = c
	}
	return ans
}

// @lc code=end
