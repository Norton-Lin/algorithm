package main

/*
 * @lc app=leetcode.cn id=2390 lang=golang
 *
 * [2390] 从字符串中移除星号
 */

// @lc code=start
// 队列

func RemoveStars(s string) string {
	var ans []byte
	for _, c := range s {
		if c == '*' {
			if len(ans) > 0 {
				ans = ans[:len(ans)-1]
				continue
			}
		}
		ans = append(ans, byte(c))
	}
	return string(ans)
}

// @lc code=end
