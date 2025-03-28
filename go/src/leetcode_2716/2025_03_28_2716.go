package main

/*
 * @lc app=leetcode.cn id=2716 lang=golang
 *
 * [2716] 最小化字符串长度
 */

// @lc code=start
// 如果字符数量为不是1，可以变为1
func MinimizedStringLength(s string) int {
	record := make(map[rune]bool)
	for _, c := range s {
		record[c] = true
	}
	return len(record)
}

// @lc code=end
