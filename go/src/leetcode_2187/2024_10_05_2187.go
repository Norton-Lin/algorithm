package main

/*
 * @lc app=leetcode.cn id=2187 lang=golang
 *
 * [2187] 完成旅途的最少时间
 */

// @lc code=start
func minimumTime(time []int, totalTrips int) int64 {
	l, r := int64(1), int64(totalTrips*time[0])
	for l <= r {
		mid := (l + r) / 2
		if check(mid, time, totalTrips) {
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return l
}

func check(cur int64, time []int, totalTrips int) bool {
	record := int64(0)
	for _, i := range time {
		record += cur / int64(i)
		if record >= int64(totalTrips) {
			return true
		}
	}
	return false
}

// @lc code=end
