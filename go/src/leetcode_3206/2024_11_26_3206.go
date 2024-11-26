package main

/*
 * @lc app=leetcode.cn id=3206 lang=golang
 *
 * [3206] 交替组 I
 */

// @lc code=start
func NumberOfAlternatingGroups(colors []int) int {
	ans := 0
	n := len(colors)
	for i, color := range colors {
		if colors[(i+n-1)%n] != color && colors[(i+n+1)%n] != color {
			ans++
		}
	}
	return ans
}

// @lc code=end
