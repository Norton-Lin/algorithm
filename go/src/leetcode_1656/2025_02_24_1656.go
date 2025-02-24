package main

/*
 * @lc app=leetcode.cn id=1656 lang=golang
 *
 * [1656] 设计有序流
 */

// @lc code=start
type OrderedStream struct {
	arr []string
	ptr int
}

func Constructor(n int) OrderedStream {
	arr := make([]string, n+1)
	return OrderedStream{arr, 1}
}

func (this *OrderedStream) Insert(idKey int, value string) []string {
	this.arr[idKey] = value
	ans := make([]string, 0)
	//fmt.Println(this.arr,this.ptr,idKey)
	if idKey == this.ptr {
		for ; this.ptr < len(this.arr) && this.arr[this.ptr] != ""; this.ptr++ {
			ans = append(ans, this.arr[this.ptr])
		}
	}
	return ans
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * obj := Constructor(n);
 * param_1 := obj.Insert(idKey,value);
 */
// @lc code=end
