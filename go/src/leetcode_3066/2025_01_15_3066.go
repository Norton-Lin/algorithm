package main

import "container/heap"

/*
 * @lc app=leetcode.cn id=3066 lang=golang
 *
 * [3066] 超过阈值的最少操作数 II
 */

// @lc code=start
type PriorityQueue []int

func (p PriorityQueue) Less(i, j int) bool {
	return p[i] < p[j]
}
func (p PriorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p PriorityQueue) Len() int {
	return len(p)
}
func (p *PriorityQueue) Push(x interface{}) {
	*p = append(*p, x.(int))
}
func (p *PriorityQueue) Pop() interface{} {
	old := *p
	n := len(old)
	res := (old)[n-1]
	(*p) = old[0 : n-1]
	return res
}
func MinOperations(nums []int, k int) int {
	p := &PriorityQueue{}
	for _, num := range nums {
		*p = append(*p, num)
	}
	heap.Init(p)
	ans := 0
	x := heap.Pop(p).(int)
	y := heap.Pop(p).(int)
	for x < k {
		ans++
		heap.Push(p, 2*x+y)
		x = heap.Pop(p).(int)
		if len(*p) > 0 {
			y = heap.Pop(p).(int)
		}

	}
	return ans
}

// @lc code=end
