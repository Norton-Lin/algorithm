package main

/*
 * @lc app=leetcode.cn id=1328 lang=golang
 *
 * [1328] 破坏回文串
 */

// @lc code=start
// 本身是回文，越早换a越好
// 特殊情况 一个字母、全都是a
func BreakPalindrome(palindrome string) string {
	res := palindrome
	n := len(palindrome)
	input := []rune(palindrome)
	flag := true
	for i := 0; i < n/2; i++ {
		if input[i] > 'a' {
			input[i] = 'a'
			flag = false
			break
		}
	}
	if flag {
		input[n-1] = 'b'
	}
	res = string(input)
	if n == 1 {
		res = ""
	}
	return res
}

// @lc code=end
