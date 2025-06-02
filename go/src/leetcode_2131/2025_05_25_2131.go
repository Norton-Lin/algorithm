package main

import "strings"

/*
 * @lc app=leetcode.cn id=2131 lang=golang
 *
 * [2131] 连接两字母单词得到的最长回文串
 */

// @lc code=start
// 双指针
func LongestPalindrome(words []string) int {
	ans := 0
	records := make(map[string]int)
	flag := true
	for _, word := range words {
		records[word]++
	}
	for _, word := range words {
		recv := string(word[1]) + string(word[0])
		if records[recv] > 0 {
			if strings.Compare(recv, word) != 0 {
				ans += 2
			} else {
				if records[recv]%2 == 1 {
					if flag {
						ans += 2
						flag = false
					}
				} else {
					ans += 2
				}
			}
			records[recv]--

		}
	}
	return ans
}

// @lc code=end
