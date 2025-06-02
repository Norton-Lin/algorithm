package main

import "strings"

/*
 * @lc app=leetcode.cn id=2942 lang=golang
 *
 * [2942] 查找包含给定字符的单词
 */

// @lc code=start
func FindWordsContaining(words []string, x byte) []int {
	ans := make([]int, 0)
	char := string(x)
	for i, word := range words {
		if strings.Contains(word, char) {
			ans = append(ans, i)
		}
	}
	return ans
}

// @lc code=end
