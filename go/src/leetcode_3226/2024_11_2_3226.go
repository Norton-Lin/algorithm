package main

import (
	"strconv"
)

/*
 * @lc app=leetcode.cn id=3226 lang=golang
 *
 * [3226] 使两个整数相等的位更改次数
 */

// @lc code=start
func MinChanges(n int, k int) int {
	ans := 0
	ns := strconv.FormatInt(int64(n), 2)
	ks := strconv.FormatInt(int64(k), 2)
	n1 := len(ns)
	n2 := len(ks)
	diff := n1 - n2
	if diff < 0 {
		return -1
	}
	for i := 0; i < diff; i++ {
		if ns[i] == '1' {
			ans++
		}
	}
	for i := 0; i < n2; i++ {
		if ns[i+diff] != ks[i] {
			if ks[i] == '0' {
				ans++
			} else {
				ans = -1
				break
			}
		}
	}
	return ans
}

// @lc code=end
