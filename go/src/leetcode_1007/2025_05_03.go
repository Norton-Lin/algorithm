package main

/*
 * @lc app=leetcode.cn id=1007 lang=golang
 *
 * [1007] 行相等的最少多米诺旋转
 */

// @lc code=start
func MinDominoRotations(tops []int, bottoms []int) int {
	records := make([][]int, 2)
	records[0] = make([]int, 6) // top记录
	records[1] = make([]int, 6) // bottom 记录
	n := len(tops)
	ans := -1
	for i := 0; i < n; i++ {
		if tops[i] != bottoms[i] {
			records[1][bottoms[i]-1]++
		}
		records[0][tops[i]-1]++
	}
	for _, record := range records {
		if record[0]+record[1] == n {
			ans = min(record[0], record[1])
		}
	}
	return ans
}

// @lc code=end
