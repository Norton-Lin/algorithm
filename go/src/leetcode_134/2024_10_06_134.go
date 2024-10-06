package main

/*
 * @lc app=leetcode.cn id=134 lang=golang
 *
 * [134] 加油站
 */

// @lc code=start
// 如果cost总和大于gas总和 -1 否则必有解
func CanCompleteCircuit(gas []int, cost []int) int {
	ans := -1
	cur := 0
	n := len(gas)
	for i := 0; i < n; i++ {
		cur += gas[i] - cost[i]
	}
	if cur < 0 {
		return -1
	}
	cur = 0
	for i := 0; i < n; i++ {
		cur += gas[i] - cost[i]
		if cur < 0 {
			cur = 0
			ans = -1
		} else {
			if ans == -1 {
				ans = i
			}
		}
	}
	return ans
}

// @lc code=end
