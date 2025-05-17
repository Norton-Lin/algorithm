package main

/*
 * @lc app=leetcode.cn id=75 lang=golang
 *
 * [75] 颜色分类
 */

// @lc code=start
func SortColors(nums []int) {
	record := make([]int, 3)
	for _, num := range nums {
		record[num]++
	}
	for i := 0; i < record[0]; i++ {
		nums[i] = 0
	}
	for i := record[0]; i < record[0]+record[1]; i++ {
		nums[i] = 1
	}
	for i := record[0] + record[1]; i < record[0]+record[1]+record[2]; i++ {
		nums[i] = 2
	}
}

// @lc code=end
