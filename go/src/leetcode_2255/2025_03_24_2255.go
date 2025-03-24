package main

import "strings"

/*
 * @lc app=leetcode.cn id=2255 lang=golang
 *
 * [2255] 统计是给定字符串前缀的字符串数目
 */

// @lc code=start
func CountPrefixes(words []string, s string) int {
	ans := 0
	for _, word := range words {
		if strings.HasPrefix(s, word) {
			ans++
		}
	}
	return ans
}

// @lc code=end
