package main

/*
 * @lc app=leetcode.cn id=3211 lang=golang
 *
 * [3211] 生成不含相邻零的二进制字符串
 */

// @lc code=start
func ValidStrings(n int) []string {
	if n == 1 {
		return []string{"0", "1"}
	}
	ans := []string{}
	backtrace(n, &ans, "0")
	backtrace(n, &ans, "1")
	return ans
}

func backtrace(n int, ans *[]string, cur string) {
	if n == 0 {
		*ans = append(*ans, cur)
		return
	}
	length := len(cur)
	if cur[length-1] == '1' {
		backtrace(n-1, ans, cur+"0")
	}
	backtrace(n-1, ans, cur+"1")
}

// @lc code=end
