package main

/*
 * @lc app=leetcode.cn id=3005 lang=golang
 *
 * [3005] 最大频率元素计数
 */

// @lc code=start
func maxFrequencyElements(nums []int) int {
	ans := 0
	cnt := 0
	records := make([]int, 101)
	for _, num := range nums {
		records[num]++
	}
	for _, num := range records {
		ans = max(ans, num)
	}
	for _, num := range records {
		if num == ans {
			cnt++
		}
	}
	return cnt * ans
}

// @lc code=end
