package main

import "math"

/*
 * @lc app=leetcode.cn id=3233 lang=golang
 *
 * [3233] 统计不是特殊数字的数字数量
 */

// @lc code=start
// 欧拉筛全记录更快，单一判断会慢
func NonSpecialCount(l int, r int) int {
	ans := r - l + 1
	start := int(math.Sqrt(float64(l)))
	if start*start < l {
		start++
	}
	for start*start < r {
		if isPrime(start) {
			ans--
		}
		start++
	}
	return ans
}

// 快速欧拉筛判断质数
func isPrime(num int) bool {
	if num <= 3 {
		return num > 1
	}
	if num%6 != 1 && num%6 != 5 {
		return false
	}
	sqrt := int(math.Sqrt(float64(num)))
	for i := 5; i <= sqrt; i += 6 {
		if num%i == 0 || num%(i+2) == 0 {
			return false
		}
	}
	return true
}

// @lc code=end
