package main

import "math"

/*
 * @lc app=leetcode.cn id=633 lang=golang
 *
 * [633] 平方数之和
 */

// @lc code=start
func JudgeSquareSum(c int) bool {
	j := int(math.Sqrt(float64(c)))
	for i := 0; i <= j; {
		cur := i*i + j*j
		if cur == c {
			return true
		} else if cur > c {
			j--
		} else {
			i++
		}
	}
	return false
}

// @lc code=end
