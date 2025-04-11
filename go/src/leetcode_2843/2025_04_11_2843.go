package main

import "strconv"

/*
 * @lc app=leetcode.cn id=2843 lang=golang
 *
 * [2843] 统计对称整数的数目
 */

// @lc code=start
func CountSymmetricIntegers(low int, high int) int {
	ans := 0
	for i := low; i <= high; i++ {
		num := []rune(strconv.Itoa(i))
		if len(num)%2 == 1 {
			continue
		}
		sum1, sum2 := int32(0), int32(0)
		for l, r := 0, len(num)-1; l < r; l, r = l+1, r-1 {
			sum1 += num[l]
			sum2 += num[r]
		}
		if sum1 == sum2 {
			ans++
		}
	}
	return ans
}

// @lc code=end
