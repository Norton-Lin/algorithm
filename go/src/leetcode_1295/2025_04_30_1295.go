package main

/*
 * @lc app=leetcode.cn id=1295 lang=golang
 *
 * [1295] 统计位数为偶数的数字
 */

// @lc code=start
func FindNumbers(nums []int) int {
	ans := 0
	for _, num := range nums {
		cnt := 0
		for num > 0 {
			num /= 10
			cnt++
		}
		if cnt%2 == 0 {
			ans++
		}
	}
	return ans
}

// @lc code=end
