package main

import "math"

/*
 * @lc app=leetcode.cn id=743 lang=golang
 *
 * [743] 网络延迟时间
 */

// @lc code=start
// 迪杰斯特拉
func NetworkDelayTime(times [][]int, n int, k int) int {
	visit := make([]bool, n)
	dists := make([]int, n)
	ways := make([][]int, n)
	ans := 0
	for i := 0; i < n; i++ {
		ways[i] = make([]int, n)
		for j := range ways[i] {
			ways[i][j] = math.MaxInt / 2
		}
		dists[i] = math.MaxInt / 2
	}
	// 记录路径
	for _, time := range times {
		ways[time[0]-1][time[1]-1] = time[2]
	}
	//visit[k-1] = true
	dists[k-1] = 0

	for i := 0; i < n; i++ {
		x := -1
		for y, u := range visit {
			if !u && (x == -1 || dists[x] > dists[y]) {
				x = y
			}
		}
		visit[x] = true
		for y, time := range ways[x] {
			dists[y] = min(dists[y], time+dists[x])
		}
	}
	for _, dist := range dists {
		if dist == math.MaxInt/2 {
			ans = -1
			break
		}
		ans = max(ans, dist)
	}
	return ans
}

// @lc code=end
