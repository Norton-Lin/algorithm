package main

/*
 * @lc app=leetcode.cn id=3516 lang=golang
 *
 * [3516] 找到最近的人
 */

// @lc code=start
func FindClosest(x int, y int, z int) int {
	num1 := z - x
	num2 := z - y
	ans := 0
	if num1 < 0 {
		num1 = -num1
	}
	if num2 < 0 {
		num2 = -num2
	}
	if num1 < num2 {
		ans = 1
	} else if num1 > num2 {
		ans = 2
	}
	return ans
}

// @lc code=end
