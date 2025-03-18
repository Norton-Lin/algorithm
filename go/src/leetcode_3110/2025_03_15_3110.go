package main

/*
 * @lc app=leetcode.cn id=3110 lang=golang
 *
 * [3110] 字符串的分数
 */

// @lc code=start
func ScoreOfString(s string) int {
	ans := 0
	n := len(s)
	for i := 0; i < n-1; i++ {
		// 注意byte溢出
		value := int(s[i+1]) - int(s[i])
		if value < 0 {
			ans -= value
		} else {
			ans += value
		}

	}
	return ans
}

// @lc code=end
