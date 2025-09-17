package main

import (
	"container/heap"
)

/*
 * @lc app=leetcode.cn id=2349 lang=golang
 *
 * [2349] 设计数字容器系统
 */

// @lc code=start
// 优先队列
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
	res := old[n-1]
	*p = old[0 : n-1]
	return res
}

type NumberContainers struct {
	nums    map[int]int
	records map[int]*PriorityQueue
}

func Constructor() NumberContainers {
	nums := make(map[int]int)
	records := make(map[int]*PriorityQueue)
	return NumberContainers{nums, records}
}

func (nc *NumberContainers) Change(index int, number int) {
	nc.nums[index] = number
	if nc.records[number] == nil {
		nc.records[number] = &PriorityQueue{}
	}
	heap.Push(nc.records[number], index)
}

func (nc *NumberContainers) Find(number int) int {
	cur := -1
	arr := nc.records[number]
	if arr == nil {
		return cur
	}
	//fmt.Println(arr,number,this.nums)
	for arr.Len() > 0 {
		num := heap.Pop(arr).(int)
		if nc.nums[num] == number {
			heap.Push(nc.records[number], num)
			cur = num
			break
		}
	}
	return cur
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Change(index,number);
 * param_2 := obj.Find(number);
 */

/**
 * Your NumberContainers object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Change(index,number);
 * param_2 := obj.Find(number);
 */
// @lc code=end
