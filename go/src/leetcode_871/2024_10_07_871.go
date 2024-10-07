package main

import (
	"container/heap"
	"sort"
)

/*
 * @lc app=leetcode.cn id=871 lang=golang
 *
 * [871] 最低加油次数
 */

// @lc code=start
// 前往target
// stations 表示在 station1 有汽油 station2
// stations 按照stations1递增排序
// 优先队列
// 到达i处加油站时必须有汽油x升才能到下一个点位
// 优先队列记录之前

func MinRefuelStops(target int, startFuel int, stations [][]int) int {
	ans := 0
	pre := 0
	queue := priorityQueue{}
	for _, state := range stations {
		startFuel -= state[0] - pre //当前油量
		for startFuel < 0 && queue.Len() > 0 {
			startFuel += heap.Pop(&queue).(int)
			ans++
		}
		if startFuel < 0 {
			ans = -1
			break
		}
		heap.Push(&queue, state[1])
		pre = state[0]
	}
	startFuel -= target - pre
	for startFuel < 0 && queue.Len() > 0 {
		startFuel += heap.Pop(&queue).(int)
		ans++
	}
	if startFuel < 0 {
		ans = -1
	}
	return ans
}

type priorityQueue struct {
	sort.IntSlice
}

func (q priorityQueue) Less(i, j int) bool {
	return q.IntSlice[i] > q.IntSlice[j]
}
func (q *priorityQueue) Pop() interface{} {
	cur := q.IntSlice
	l := len(cur)
	q.IntSlice = cur[:l-1]
	return cur[l-1]
}

func (q *priorityQueue) Push(v interface{}) {
	q.IntSlice = append(q.IntSlice, v.(int))
}

// @lc code=end
