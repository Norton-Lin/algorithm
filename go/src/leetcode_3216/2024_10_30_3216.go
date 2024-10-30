package main

/*
 * @lc app=leetcode.cn id=3216 lang=golang
 *
 * [3216] 交换后字典序最小的字符串
 */

// @lc code=start
func GetSmallestString(s string) string {
	str := []rune(s)
	cur := str[0]
	n := len(s)
	for i := 1; i < n; i++ {
		if cur%2 == str[i]%2 && cur > str[i] {
			str[i-1] = str[i]
			str[i] = cur
			break
		}
		cur = str[i]
	}
	return string(str)
}

// @lc code=end
