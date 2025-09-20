package main

import (
	"math"
	"strconv"
)

/*
 * @lc app=leetcode.cn id=3508 lang=golang
 *
 * [3508] 设计路由器
 */

// @lc code=start
type Router struct {
	queue       [][]int
	memoryLimit int
	curTime     int
	tag         map[string]bool
	records     map[int][][]int
}

func Constructor(memoryLimit int) Router {
	queue := make([][]int, 0)
	curTime := 0
	tag := make(map[string]bool)
	records := make(map[int][][]int)
	return Router{queue, memoryLimit, curTime, tag, records}
}

func (this *Router) AddPacket(source int, destination int, timestamp int) bool {
	str := strconv.Itoa(source) + "_" + strconv.Itoa(destination) + "_" + strconv.Itoa(timestamp)
	if _, ok := this.tag[str]; ok {
		return false
	} else {
		this.tag[str] = true
	}
	if len(this.queue) == this.memoryLimit {
		old := this.queue[0]
		delete(this.tag, strconv.Itoa(old[0])+"_"+strconv.Itoa(old[1])+"_"+strconv.Itoa(old[2]))
		this.queue = this.queue[1:]
		this.curTime = this.queue[0][2]
		this.records[old[1]] = this.records[old[1]][1:]
	}
	arr := []int{source, destination, timestamp}
	this.queue = append(this.queue, arr)
	this.records[destination] = append(this.records[destination], arr)
	return true
}

func (this *Router) ForwardPacket() []int {
	if len(this.queue) == 0 {
		return []int{}
	}
	old := this.queue[0]
	delete(this.tag, strconv.Itoa(old[0])+"_"+strconv.Itoa(old[1])+"_"+strconv.Itoa(old[2]))
	this.queue = this.queue[1:]
	this.records[old[1]] = this.records[old[1]][1:]
	if len(this.queue) > 0 {
		this.curTime = this.queue[0][2]
	} else {
		this.curTime = math.MaxInt
	}
	return old
}

func (this *Router) GetCount(destination int, startTime int, endTime int) int {
	start := binarySearch(this.records[destination], startTime-1)
	end := binarySearch(this.records[destination], endTime)
	return end - start
}

// 找大于target的第一个数
func binarySearch(nums [][]int, target int) int {
	l, r := 0, len(nums)
	for l < r {
		m := (l + r) / 2
		if nums[m][2] <= target {
			l = m + 1
		} else {
			r = m
		}
	}
	return l
}

/**
 * Your Router object will be instantiated and called as such:
 * obj := Constructor(memoryLimit);
 * param_1 := obj.AddPacket(source,destination,timestamp);
 * param_2 := obj.ForwardPacket();
 * param_3 := obj.GetCount(destination,startTime,endTime);
 */
// @lc code=end
