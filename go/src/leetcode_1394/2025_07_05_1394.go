package main

/*
 * @lc app=leetcode.cn id=1394 lang=golang
 *
 * [1394] 找出数组中的幸运数
 */

// @lc code=start
func FindLucky(arr []int) int {
	records := make(map[int]int)
	ans := -1
	for _, num := range arr {
		records[num]++
	}
	for key, value := range records {
		if key == value && key > ans {
			ans = key
		}
	}
	return ans
}

// @lc code=end
