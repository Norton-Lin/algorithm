package main

/*
 * @lc app=leetcode.cn id=2414 lang=golang
 *
 * [2414] 最长的字母序连续子字符串的长度
 */

// @lc code=start
func LongestContinuousSubstring(s string) int {
	ans, cur, n := 1, 1, len(s)
	for i := 1; i < n; i++ {
		if s[i] == s[i-1]+1 {
			cur++
			if ans < cur {
				ans = cur
			}
		} else {
			cur = 1
		}
	}
	return ans
}

// @lc code=end
