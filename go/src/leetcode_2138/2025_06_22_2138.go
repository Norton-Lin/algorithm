package main

/*
 * @lc app=leetcode.cn id=2138 lang=golang
 *
 * [2138] 将字符串拆分为若干长度为 k 的组
 */

// @lc code=start
func DivideString(s string, k int, fill byte) []string {
	n := len(s)
	for i := 0; i < (k-n%k)%k; i++ {
		s += string(fill)
	}
	ans := make([]string, 0)
	//fmt.Println(s)
	n = len(s)
	for i := 0; i < n; i += k {
		ans = append(ans, s[i:i+k])
	}
	return ans
}

// @lc code=end
