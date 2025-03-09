package main

import (
	"container/heap"
	"sort"
)

// grid中提取k个元素，每一行提取个数的不超过limits，使其和最大
// 优先队列
type Item struct {
	value int
	line  int
}
type PriorityQueue []Item

func (p PriorityQueue) Len() int {
	return len(p)
}

func (p PriorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p PriorityQueue) Less(i, j int) bool {
	return p[i].value < p[j].value
}
func (p *PriorityQueue) Pop() interface{} {
	old := *p
	n := len(old)
	res := old[n-1]
	*p = old[0 : n-1]
	return res
}
func (p *PriorityQueue) Push(x interface{}) {
	*p = append(*p, x.(Item))
}
func maxSum(grid [][]int, limits []int, k int) int64 {
	ans := int64(0)
	m, n := len(grid), len(grid[0])
	for i := 0; i < m; i++ {
		sort.Ints(grid[i])
	}
	record := &PriorityQueue{}
	for i := 0; i < m; i++ {
		heap.Push(record, Item{grid[i][n-1], i})
		grid[i] = grid[i][0 : n-1]
	}

	for ; k > 0; k-- {
		cur := heap.Pop(record).(Item)
		l := len(grid[cur.line])
		if limits[cur.line] < n-l {
			k++
			continue
		}
		ans += int64(cur.value)

		if l == 0 {
			continue
		}
		heap.Push(record, Item{grid[cur.line][l-1], cur.line})
		grid[cur.line] = grid[cur.line][0 : l-1]

	}
	return ans
}
