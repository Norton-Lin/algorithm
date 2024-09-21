package main

/*
 * @lc app=leetcode.cn id=2374 lang=golang
 *
 * [2374] 边积分最高的节点
 */

// @lc code=start
func EdgeScore(edges []int) int {
	n := len(edges)
	record := make([]int, n)
	num := 0
	ans := 0
	for i, edge := range edges {
		record[edge] += i
		if num < record[edge] {
			num = record[edge]
			ans = edge
		} else if num == record[edge] {
			ans = min(ans, edge)
		}
	}
	return ans
}

// @lc code=end
