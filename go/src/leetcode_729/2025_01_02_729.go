package main

import (
	"math"

	"github.com/emirpasic/gods/trees/redblacktree"
)

/*
 * @lc app=leetcode.cn id=729 lang=golang
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start
type MyCalendar struct {
	*redblacktree.Tree
}

func Constructor() MyCalendar {
	t := redblacktree.NewWithIntComparator()
	t.Put(math.MaxInt32, nil) // 哨兵，简化代码
	return MyCalendar{t}
}

func (c MyCalendar) Book(start, end int) bool {
	node, _ := c.Ceiling(end)
	it := c.IteratorAt(node)
	if !it.Prev() || it.Value().(int) <= start {
		c.Put(start, end)
		return true
	}
	return false
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Book(startTime,endTime);
 */
// @lc code=end
