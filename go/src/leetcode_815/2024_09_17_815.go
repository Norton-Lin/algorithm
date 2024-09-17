package main

/*
 * @lc app=leetcode.cn id=815 lang=golang
 *
 * [815] 公交路线
 */

// @lc code=start
func NumBusesToDestination(routes [][]int, source int, target int) int {
	ans := 0
	if source == target {
		return ans
	}
	ways := make(map[int][]int)
	// 每个站有哪些个车
	for i, route := range routes {
		for _, state := range route {
			ways[state] = append(ways[state], i)
		}
	}
	ans++
	queue := make([]int, 0)              //BFS队列
	visited := make([]bool, len(routes)) // 记忆化搜索,坐过哪些车
	// 当前车站所有公交车
	for _, route := range ways[source] {
		queue = append(queue, route)
		visited[route] = true
	}
	size := 0
	for len(queue) != 0 {
		//检查所有路线
		size = len(queue)
		for i := 0; i < size; i++ { //当前站台可以坐的所有车
			line := queue[0]
			queue = queue[1:]
			// 查看当前线路
			for _, state := range routes[line] {
				if state == target {
					return ans
				}
				for _, route := range ways[state] {
					//没坐过的车
					if !visited[route] {
						visited[route] = true
						queue = append(queue, route)
					}
				}
			}
		}
		ans++

	}
	return -1
}

// @lc code=end
