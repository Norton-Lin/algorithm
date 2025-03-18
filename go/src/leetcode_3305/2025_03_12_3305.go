package main

/*
 * @lc app=leetcode.cn id=3305 lang=golang
 *
 * [3305] 元音辅音字符串计数 I
 */

// @lc code=start
func countOfSubstrings(word string, k int) int {
	ans := 0
	n := len(word)
	record := make([][]int, n+1)
	record[0] = make([]int, 6)
	for i := 0; i < n; i++ {
		record[i+1] = make([]int, 6)
		record[i+1][0] = record[i][0]
		record[i+1][1] = record[i][1]
		record[i+1][2] = record[i][2]
		record[i+1][3] = record[i][3]
		record[i+1][4] = record[i][4]
		record[i+1][5] = record[i][5]
		switch word[i] {
		case 'a':
			record[i+1][0]++
		case 'e':
			record[i+1][1]++
		case 'i':
			record[i+1][2]++
		case 'o':
			record[i+1][3]++
		case 'u':
			record[i+1][4]++
		default:
			record[i+1][5]++
		}
	}
	for j := 5 + k; j <= n; j++ {
		for i := j - 5 - k; i >= 0; i-- {
			if check(record, i, j, k) {
				ans++
			}
		}
	}
	return ans
}
func check(record [][]int, i int, j int, k int) bool {
	ans := true
	if record[j][5]-record[i][5] != k {
		ans = false
		return ans
	}
	for l := 0; l < 5; l++ {
		if record[j][l]-record[i][l] == 0 {
			ans = false
			break
		}
	}
	return ans
}

// @lc code=end
