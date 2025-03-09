package main

/*
 * @lc app=leetcode.cn id=2502 lang=golang
 *
 * [2502] 设计内存分配器
 */

// @lc code=start
// 每次分配数据要连续
type Allocator struct {
	arr    []int
	record map[int][]int
}

func Constructor(n int) Allocator {
	return Allocator{make([]int, n), make(map[int][]int)}
}

func (this *Allocator) Allocate(size int, mID int) int {
	start := 0
	cur := 0
	res := -1
	n := len(this.arr)
	for ; cur-start < size && cur < n; cur++ {
		if this.arr[cur] != 0 {
			start = cur + 1
		}
	}
	if cur-start < size || cur == n+1 {
		return res
	}
	res = start
	for ; start < cur; start++ {
		this.arr[start] = mID
		this.record[mID] = append(this.record[mID], start)
	}
	return res
}

func (t *Allocator) FreeMemory(mID int) int {
	res := len(t.record[mID])
	for _, index := range t.record[mID] {
		t.arr[index] = 0
	}
	t.record[mID] = make([]int, 0)
	return res
}

/**
 * Your Allocator object will be instantiated and called as such:
 * obj := Constructor(n);
 * param_1 := obj.Allocate(size,mID);
 * param_2 := obj.FreeMemory(mID);
 */
// @lc code=end
