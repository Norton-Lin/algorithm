package main

/*
 * @lc app=leetcode.cn id=1287 lang=golang
 *
 * [1287] 有序数组中出现次数超过25%的元素
 */

// @lc code=start
// 注意小数问题
func findSpecialInteger(arr []int) int {
	n := len(arr)
	record := float64(n) / 4
	cur := 1

	ans := arr[n-1]
	for i := 1; i < n; i++ {
		if float64(cur) > record {
			ans = arr[i-1]
			break
		}
		if arr[i] == arr[i-1] {
			cur++
		} else {
			cur = 1
		}
	}
	return ans
}

// @lc code=end
