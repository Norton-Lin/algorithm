package main

import "sort"

/*
 * @lc app=leetcode.cn id=1760 lang=golang
 *
 * [1760] 袋子里最少数目的球
 */

// @lc code=start
type PriorityQueue []int

func (p PriorityQueue) Len() int {
	return len(p)
}
func (p PriorityQueue) Less(i, j int) bool {
	return p[i] > p[j]
}
func (p PriorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}
func (p *PriorityQueue) Pop() interface{} {
	old := *p
	n := len(old)
	item := old[n-1]
	*p = old[0 : n-1]
	return item
}
func (p *PriorityQueue) Push(x interface{}) {
	*p = append(*p, x.(int))
}

// 优先队列无法处理 [9],2 答案 [3,3,3]这种情况
// 二分查找答案
// 给定m 能否在maxOperations次操作中，让所有袋子变成m 二分找这个m
// k个袋子 nums[i]/k <= m
// km >= nums[i]
// 对k个袋子操作次数为 nums[i]/m - 1
func MinimumSize(nums []int, maxOperations int) int {
	max := 0
	//找最大值
	for _, num := range nums {
		if max < num {
			max = num
		}
	}
	// y其实就是 mid = （left+right）/2
	return sort.Search(max, func(y int) bool {
		//不用再缩小范围
		if y == 0 {
			return false
		}
		ops := 0 //这是次数
		for _, num := range nums {
			ops += (num - 1) / y
		}
		return ops <= maxOperations
	})
}

// @lc code=end
