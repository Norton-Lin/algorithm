package main

/*
 * @lc app=leetcode.cn id=3243 lang=golang
 *
 * [3243] 新增道路查询后的最短距离 I
 */

// @lc code=start
// 每次都深搜
// 广搜不能深搜
func ShortestDistanceAfterQueries(n int, queries [][]int) []int {
	neighbors := make([][]int, n)
	for i := 0; i < n-1; i++ {
		neighbors[i] = append(neighbors[i], i+1)
	}
	var res []int
	for _, query := range queries {
		neighbors[query[0]] = append(neighbors[query[0]], query[1])
		res = append(res, bfs(n, neighbors))
	}
	return res
}

func bfs(n int, neighbors [][]int) int {
	dist := make([]int, n)
	for i := 1; i < n; i++ {
		dist[i] = -1
	}
	q := []int{0}
	for len(q) > 0 {
		x := q[0]
		q = q[1:]
		for _, y := range neighbors[x] {
			if dist[y] >= 0 {
				continue
			}
			q = append(q, y)
			dist[y] = dist[x] + 1
		}
	}
	return dist[n-1]
}

// @lc code=end
