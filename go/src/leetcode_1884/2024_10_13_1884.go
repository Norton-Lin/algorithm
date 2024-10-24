package main

import "math"

/*
 * @lc app=leetcode.cn id=1884 lang=golang
 *
 * [1884] 鸡蛋掉落-两枚鸡蛋
 */

// @lc code=start
// 找第一个k 2*k(k+1) > n
func TwoEggDrop(n int) int {
	ans := int(math.Sqrt(float64(n * 2)))
	for ans*(ans+1)/2 < n {
		ans++
	}
	return ans
}

// @lc code=end
