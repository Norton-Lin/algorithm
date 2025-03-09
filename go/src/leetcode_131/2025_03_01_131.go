package main

/*
 * @lc app=leetcode.cn id=131 lang=golang
 *
 * [131] 分割回文串
 */

// @lc code=start
var ans [][]string

// 回溯
// 想优化可以用dp
func Partition(s string) [][]string {
	ans = make([][]string, 0)
	backtrack(s, 0, make([]string, 0))
	return ans
}

// 每次向下都找会回文，每找到一个回文，就去寻找下一个
func backtrack(s string, index int, cur []string) {
	n := len(s)
	if index >= n {
		arr := make([]string, len(cur))
		copy(arr, cur)
		ans = append(ans, arr)
		return
	}
	for i := index + 1; i <= n; i++ {
		if check(s[index:i]) {
			cur = append(cur, s[index:i])
			backtrack(s, i, cur)
			cur = cur[0 : len(cur)-1]
		}
	}
}
func check(s string) bool {
	ans := true
	left, right := 0, len(s)-1
	for left < right {
		if s[left] != s[right] {
			ans = false
			break
		}
		left++
		right--
	}
	return ans
}

// @lc code=end
