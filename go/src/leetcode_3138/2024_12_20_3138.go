package main

/*
 * @lc app=leetcode.cn id=3138 lang=golang
 *
 * [3138] 同位字符串连接的最小长度
 */

// @lc code=start
// 首先t长度可以被s长度整除
// 最小为1 最大为len(s)
// 前缀和匹配
func MinAnagramLength(s string) int {
	ans := 0
	l := len(s)
	record := make([][]int, 0)
	curRecord := make([]int, 26)
	for j := 0; j < 26; j++ {
		curRecord[j] = 0
	}
	for i := 0; i < l; i++ {
		curRecord[s[i]-'a']++
		cur := make([]int, 26)
		copy(cur, curRecord)
		record = append(record, cur)
	}
	for i := 1; i <= l && ans == 0; i++ {
		//必须能整除
		if l%i != 0 {
			continue
		}
		tag := true
		for j := i - 1; j < l-i; j += i {
			for k := 0; k < 26; k++ {
				if record[j+i][k]-record[j][k] != record[i-1][k] {
					tag = false
					break
				}
			}
		}
		if tag {
			ans = i
		}
	}
	if ans == 0 {
		ans = l
	}
	return ans
}

// @lc code=end
