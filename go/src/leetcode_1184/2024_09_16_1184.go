package main

import "math"

/*
 * @lc app=leetcode.cn id=1184 lang=golang
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
// distance表示 i 到 i + 1的距离
func DistanceBetweenBusStops(distance []int, start int, destination int) int {
	ans := math.MaxInt
	n := len(distance)
	cur := 0
	for i := start; i != destination; i = (i + 1) % n {
		cur += distance[i]
	}
	ans = min(ans, cur)
	cur = 0
	for i := destination; i != start; i = (i + 1) % n {
		cur += distance[i]
	}
	ans = min(ans, cur)
	return ans
}

// @lc code=end
