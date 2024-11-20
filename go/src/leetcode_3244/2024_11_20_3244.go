package main

/*
 * @lc app=leetcode.cn id=3244 lang=golang
 *
 * [3244] 新增道路查询后的最短距离 II
 */

// @lc code=start
// 贪心
// query中，存在查询包含，被包含的点可以去掉
func ShortestDistanceAfterQueries(n int, queries [][]int) []int {
	ans := make([]int, 0)
	roads := make([]int, n)
	for i := 0; i < n; i++ {
		roads[i] = i + 1 //通往i+1
	}
	dist := n - 1
	for _, query := range queries {
		start := roads[query[0]]
		roads[query[0]] = query[1]
		for start != -1 && start < query[1] {
			start, roads[start] = roads[start], -1 //找路径
			dist--
		}
		ans = append(ans, dist)
	}

	return ans
}

// @lc code=end
