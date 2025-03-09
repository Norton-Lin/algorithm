package main

/*
 * @lc app=leetcode.cn id=1742 lang=golang
 *
 * [1742] 盒子中小球的最大数量
 */

// @lc code=start
func CountBalls(lowLimit int, highLimit int) int {
	record := make([]int, 46)
	ans := 0
	for i := lowLimit; i <= highLimit; i++ {
		cur := i
		num := 0
		for cur > 0 {
			num += cur % 10
			cur /= 10
		}
		record[num]++
		ans = max(ans, record[num])
	}
	return ans
}

// @lc code=end
