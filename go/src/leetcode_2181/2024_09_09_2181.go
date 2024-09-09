package main

/*
 * @lc app=leetcode.cn id=2181 lang=golang
 *
 * [2181] 合并零之间的节点
 */

// @lc code=start
type ListNode struct {
	Val  int
	Next *ListNode
}

//记住控制的是下一个结点
//可以直接操作源节点
func MergeNodes(head *ListNode) *ListNode {
	start := head
	//每个数字的记录指针
	num := 0
	for cur := head.Next; cur != nil; cur = cur.Next {
		if cur.Val == 0 {
			start.Next.Val = num
			start = start.Next
			num = 0
		} else {
			num += cur.Val
		}
	}
	start.Next = nil
	return head.Next
	// start := head
	// //每个数字的记录指针
	// num := 0
	// for cur := head.Next; cur != nil; cur = cur.Next {
	// 	if cur.Val == 0 {
	// 		cur.Val = num
	// 		num = 0
	// 		start.Next = cur
	// 		start = cur
	// 	} else {
	// 		num += cur.Val
	// 	}
	// }
	// return head.Next
}
