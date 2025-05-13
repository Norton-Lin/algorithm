package main

/*
 * @lc app=leetcode.cn id=3335 lang=golang
 *
 * [3335] 字符串转换后的长度 I
 */

// @lc code=start
// 一个z 转换后变2个字符
func LengthAfterTransformations(s string, t int) int {
	records := make([]int, 26)
	ans := 0
	mod := 1_000_000_007
	for _, c := range s {
		records[c-'a']++
	}
	for ; t > 0; t-- {
		pre := records[0]
		for i := 1; i < 26; i++ {
			next := records[i]
			records[i] = pre
			pre = next
		}
		records[0] = pre
		records[1] = (records[1] + pre) % mod
	}
	for _, num := range records {
		ans = (ans + num) % mod
	}
	return ans
}

// @lc code=end
