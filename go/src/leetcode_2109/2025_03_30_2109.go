package main

import "strings"

/*
 * @lc app=leetcode.cn id=2109 lang=golang
 *
 * [2109] 向字符串添加空格
 */

// @lc code=start
func AddSpaces(s string, spaces []int) string {
	records := make([]string, len(spaces)+1)
	pre := 0
	for i, num := range spaces {
		records[i] = s[pre:num]
		pre = num
	}
	records[len(spaces)] = s[pre:len(s)]
	ans := strings.Join(records, " ")
	return ans
}

// @lc code=end
