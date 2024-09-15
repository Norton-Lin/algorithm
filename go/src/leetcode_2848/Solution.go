package main

/*
 * @lc app=leetcode.cn id=2848 lang=golang
 *
 * [2848] 与车相交的点
 */
// @lc code=start
func NumberOfPoints(nums [][]int) int {
	record := make(map[int]bool)
	for _, i := range nums {
		for j := i[0]; j <= i[1]; j++ {
			if !record[j] {
				record[j] = true
			}
		}
	}
	return len(record)
}

// @lc code=end
