package main

import (
	"container/heap"
	"fmt"
)

/*
 * @lc app=leetcode.cn id=2931 lang=golang
 *
 * [2931] 购买物品的最大开销
 */

// @lc code=start
type Item struct {
	num   int64
	shop  int
	index int
}
type PriorityQueue []Item

func (q PriorityQueue) Len() int {
	return len(q)
}

func (q PriorityQueue) Less(i, j int) bool {
	return q[i].num < q[j].num
}

func (q PriorityQueue) Swap(i, j int) {
	q[i], q[j] = q[j], q[i]
}

func (q *PriorityQueue) Push(x interface{}) {
	*q = append((*q), x.(Item))
}

func (q *PriorityQueue) Pop() interface{} {
	old := *q
	n := len(old)
	item := old[n-1]
	*q = old[0 : n-1]
	return item
}

// 优先队列解法
func MaxSpending(values [][]int) int64 {
	ans := int64(0)
	queue := &PriorityQueue{}
	heap.Init(queue)
	n := len(values[0])
	m := len(values)
	l := int64(m * n)
	for i, value := range values {
		item := Item{int64(value[n-1]), i, n - 1}
		heap.Push(queue, item)
	}

	for d := int64(1); d <= l; d++ {
		cur := heap.Pop(queue).(Item)
		ans += cur.num * d
		fmt.Println(ans, cur.num)
		if cur.index > 0 {
			heap.Push(queue, Item{int64(values[cur.shop][cur.index-1]), cur.shop, cur.index - 1})
		}

	}
	return ans
}

// 排序解法， values数据已经是排好序列的了
// func maxSpending(values [][]int) int64 {
// 	ans := int64(0)
// 	record := make([]int, 0)
// 	for _, value := range values {
// 		record = append(record, value...)
// 	}
// 	sort.Ints(record)
// 	l := len(values) * len(values[0])
// 	for d := 0; d < l; d++ {
// 		ans += int64(record[d]) * int64(d+1)
// 	}
// 	return ans
// }

// @lc code=end
