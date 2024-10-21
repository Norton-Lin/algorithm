package main

/*
 * @lc app=leetcode.cn id=887 lang=golang
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
// 二分
func SuperEggDrop(k, n int) int {
	f := make([]int, k+1)
	for i := 1; ; i++ {
		for j := k; j > 0; j-- {
			f[j] += f[j-1] + 1
		}
		if f[k] >= n {
			return i
		}
	}
}

// @lc code=end
