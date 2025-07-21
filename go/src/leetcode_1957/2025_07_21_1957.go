package main

/*
 * @lc app=leetcode.cn id=1957 lang=golang
 *
 * [1957] 删除字符使字符串变好
 */

// @lc code=start
func MakeFancyString(s string) string {
	ans := make([]byte, 0)
	cnt := 1
	ans = append(ans, s[0])
	pre := ans[0]
	for _, c := range []byte(s[1:]) {
		if pre == c {
			cnt++
		} else {
			cnt = 1
		}
		if cnt == 3 {
			cnt--
		} else {
			ans = append(ans, c)
		}
		pre = c
	}
	return string(ans)
}

// @lc code=end
