package main

import "math"

/*
 * @lc app=leetcode.cn id=1534 lang=golang
 *
 * [1534] 统计好三元组
 */

// @lc code=start
// 暴力穷举 O(n^3)
// 枚举j i向j逼近,k远离j O(n^2)
func CountGoodTriplets(arr []int, a int, b int, c int) int {
	ans := 0
	n := len(arr)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if j == i {
				continue
			}
			if int(math.Abs(float64(arr[i]-arr[j]))) > a {
				continue
			}
			for k := 0; k < n; k++ {
				if k == i || k == j {
					continue
				}
				if int(math.Abs(float64(arr[j]-arr[k]))) > b {
					continue
				}
				if int(math.Abs(float64(arr[i]-arr[k]))) > c {
					continue
				}
				ans++
			}
		}
	}
	return ans
}

// @lc code=end
