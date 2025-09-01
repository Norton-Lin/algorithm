package main

import (
	"container/heap"
)

/*
 * @lc app=leetcode.cn id=1792 lang=golang
 *
 * [1792] 最大平均通过率
 */

// @lc code=start
// 每次给平均分最低的班级

type PriorityQueue [][]int

func (p PriorityQueue) Len() int {
	return len(p)
}
func (p PriorityQueue) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}

// 乘法更快
func (p PriorityQueue) Less(i, j int) bool {
	var num1, num2 float64
	num1 = float64(p[i][0]+1)/float64(p[i][1]+1) - float64(p[i][0])/float64(p[i][1])
	num2 = float64(p[j][0]+1)/float64(p[j][1]+1) - float64(p[j][0])/float64(p[j][1])
	return num1 > num2
}
func (p *PriorityQueue) Pop() interface{} {
	old := *p
	n := len(old)
	res := old[n-1]
	*p = old[0 : n-1]
	return res
}
func (p *PriorityQueue) Push(x interface{}) { //可以不用 用heap.Fix
	*p = append(*p, x.([]int))
}
func MaxAverageRatio(classes [][]int, extraStudents int) float64 {
	records := PriorityQueue{}
	var ans float64
	for _, item := range classes {
		heap.Push(&records, item)
	}
	for ; extraStudents > 0; extraStudents-- {
		cur := heap.Pop(&records).([]int)
		cur[0]++
		cur[1]++
		heap.Push(&records, cur)
	}
	for _, item := range records {
		ans += float64(item[0]) / float64(item[1])
	}
	ans /= float64(len(classes))
	return ans
}

// @lc code=end
