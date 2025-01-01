package main

import "container/heap"

/*
 * @lc app=leetcode.cn id=1705 lang=golang
 *
 * [1705] 吃苹果的最大数目
 */

// @lc code=start
// 优先队列，先变质的出队
// 判断变质：保质期时间 < 当前日，以保质期时间入队
type Item struct {
	start int
	end   int
}
type PriorityQueue []Item

func (p PriorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p PriorityQueue) Less(i, j int) bool {
	if p[i].start == p[j].start {
		return p[i].end < p[j].end
	}
	return p[i].start < p[j].start
}
func (p PriorityQueue) Len() int {
	return len(p)
}
func (p *PriorityQueue) Push(x interface{}) {
	*p = append(*p, x.(Item))
}
func (p *PriorityQueue) Pop() interface{} {
	old := *p
	n := len(old)
	x := old[n-1]
	*p = old[0 : n-1]
	return x
}
func eatenApples(apples []int, days []int) int {
	queue := &PriorityQueue{}
	heap.Init(queue)
	n := len(apples)
	ans := 0
	for i := 0; i < n; i++ {
		for j := 0; j < apples[i]; j++ {
			heap.Push(queue, Item{i, i + days[i]})
		}
	}
	cur := 0
	for queue.Len() > 0 {
		var item Item
		for queue.Len() > 0 {
			item = heap.Pop(queue).(Item)
			if item.start > cur {
				break
			}
			if item.end < cur {
				continue
			}
		}
		if item.start > cur {
			continue
		}
		if item.end < cur {
			break
		}
		ans++
		cur++
	}
	return ans
}

// @lc code=end
