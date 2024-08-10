package main

import "sort"

/*
 * @lc app=leetcode.cn id=2940 lang=golang
 *
 * [2940] 找到 Alice 和 Bob 可以相遇的建筑
 */

// @lc code=start
// 移动规则，i<j && heights[i]<heights[j],可以从i到j
// 每个查询，初始位置分别是 queries[k][0] queries[k][1]
// 找到比初始位置右边且 大于两个初始点位的坐标，否则为-1
// 从heights数组最右侧开始单调栈
// dp找区间内最大
// 还是单调栈，额，咋算呢
// 每次从query的大值出发，得到第一个比两个query大的值（用单调栈）
// 但是会爆内存吧（）
// 记录每个点开始的单调栈
func leftmostBuildingQueries(heights []int, queries [][]int) []int {
	ans := make([]int, len(queries)) //构建答案数组
	type pair struct{ h, i int }     //构建高度坐标对
	qs := make([][]pair, len(heights))
	for i, q := range queries {
		a, b := q[0], q[1]
		if a > b {
			a, b = b, a // 保证 a <= b
		}
		if a == b || heights[a] < heights[b] {
			ans[i] = b // a 直接跳到 b
		} else {
			qs[b] = append(qs[b], pair{heights[a], i}) // 离线询问
		}
	}

	st := []int{}
	for i := len(heights) - 1; i >= 0; i-- {
		for _, q := range qs[i] {
			//从后往前 单调栈二分
			j := sort.Search(len(st), func(i int) bool { return heights[st[i]] <= q.h }) - 1
			if j >= 0 { //找到答案
				ans[q.i] = st[j]
			} else {
				ans[q.i] = -1
			}
		}
		//维护单调栈
		for len(st) > 0 && heights[i] >= heights[st[len(st)-1]] {
			st = st[:len(st)-1]
		}
		//当前值是单调栈的第一个
		st = append(st, i)
	}
	return ans
}

// @lc code=end
