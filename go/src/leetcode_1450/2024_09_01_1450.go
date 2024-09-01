package main

/*
 * @lc app=leetcode.cn id=1450 lang=golang
 *
 * [1450] 在既定时间做作业的学生人数
 */

// @lc code=start
func BusyStudent(startTime []int, endTime []int, queryTime int) int {
	ans := 0
	for i := 0; i < len(startTime); i++ {
		if startTime[i] <= queryTime && endTime[i] >= queryTime {
			ans++
		}
	}
	return ans
}

// @lc code=end
