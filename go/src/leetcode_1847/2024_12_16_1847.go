package main

import (
	"math"
	"slices"

	"github.com/emirpasic/gods/v2/trees/redblacktree"
)

/*
 * @lc app=leetcode.cn id=1847 lang=golang
 *
 * [1847] 最近的房间
 */

// @lc code=start
// 暴力搜索， n * k
// 排序 nlogn,二分查询 k*logn
// 双重二分，第一次找size 第二次找id
func ClosestRoom(rooms [][]int, queries [][]int) []int {
	// 按照 size 从大到小排序
	slices.SortFunc(rooms, func(a, b []int) int { return b[1] - a[1] })

	q := len(queries)
	queryIds := make([]int, q)
	for i := range queryIds {
		queryIds[i] = i
	}
	// 按照 minSize 从大到小排序
	slices.SortFunc(queryIds, func(i, j int) int { return queries[j][1] - queries[i][1] })

	ans := make([]int, q)
	for i := range ans {
		ans[i] = -1
	}
	roomIds := redblacktree.New[int, struct{}]() // import "github.com/emirpasic/gods/v2/trees/redblacktree"
	j := 0
	for _, i := range queryIds {
		preferredId, minSize := queries[i][0], queries[i][1]
		for j < len(rooms) && rooms[j][1] >= minSize {
			roomIds.Put(rooms[j][0], struct{}{})
			j++
		}

		diff := math.MaxInt
		// 左边的差
		if node, ok := roomIds.Floor(preferredId); ok {
			diff = preferredId - node.Key
			ans[i] = node.Key
		}
		// 右边的差
		if node, ok := roomIds.Ceiling(preferredId); ok && node.Key-preferredId < diff {
			ans[i] = node.Key
		}
	}
	return ans
}

// @lc code=end
