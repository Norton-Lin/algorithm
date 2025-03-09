package main

/*
 * @lc app=leetcode.cn id=2080 lang=golang
 *
 * [2080] 区间内查询数字的频率
 */

// @lc code=start

type RangeFreqQuery struct {
	record map[int][]int
	// arr    []int
}

// 哈希记录每个值的所有下标
func Constructor(arr []int) RangeFreqQuery {
	record := make(map[int][]int)
	for index, value := range arr {
		record[value] = append(record[value], index)
	}
	// ans := RangeFreqQuery{record, arr}
	ans := RangeFreqQuery{record}
	return ans
}

// 二分查找下标区间 m*logn m查询次数 n数组长度
func (rf *RangeFreqQuery) Query(left int, right int, value int) int {
	if _, ok := rf.record[value]; !ok {
		return 0
	}
	//二分 找≥left的第一个在record里的下标 l
	//     找≤right的第一个在record里的下标 r  l-r即可
	l := lowBound(rf.record[value], left)
	r := highBound(rf.record[value], right)
	ans := r - l + 1
	// if ans < 0 {
	// 	ans = 0
	// }
	return ans
}
func lowBound(arr []int, low int) int {
	left, right := 0, len(arr)
	for left < right {
		mid := (left + right) >> 1
		if arr[mid] < low {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return left
}

func highBound(arr []int, high int) int {
	left, right := 0, len(arr)
	for left < right {
		mid := (left + right) >> 1
		if arr[mid] > high {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left - 1 // 减 1 得到“小于等于 high”的最后位置
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * obj := Constructor(arr);
 * param_1 := obj.Query(left,right,value);
 */
// @lc code=end
