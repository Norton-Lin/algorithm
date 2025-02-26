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

func (t *OrderedStream) Insert(idKey int, value string) []string {
	t.arr[idKey] = value
	ans := make([]string, 0)
	//fmt.Println(this.arr,this.ptr,idKey)
	if idKey == t.ptr {
		for ; t.ptr < len(t.arr) && t.arr[t.ptr] != ""; t.ptr++ {
			ans = append(ans, t.arr[t.ptr])
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
