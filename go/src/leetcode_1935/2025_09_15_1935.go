package main

import "strings"

/*
 * @lc app=leetcode.cn id=1935 lang=golang
 *
 * [1935] 可以输入的最大单词数
 */

// @lc code=start
func CanBeTypedWords(text string, brokenLetters string) int {
	cnt := 0
	set := make(map[rune]bool)
	for _, c := range brokenLetters {
		set[c] = true
	}
	for _, str := range strings.Split(text, " ") {
		flag := true
		for _, c := range str {
			if set[c] {
				flag = false
			}
		}
		if flag {
			cnt++
		}
	}
	return cnt
}

// @lc code=end
