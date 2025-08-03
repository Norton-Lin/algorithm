package main

import "fmt"

/*
 * @lc app=leetcode.cn id=2106 lang=golang
 *
 * [2106] 摘水果
 */

// @lc code=start
// 左端点 ：l , max(0,startPos-k)<=l<=startPos
// 右端点 : r,  startPos<=r<=min(len-1,startPos+k-2l)
// 区间 [l,r]
func maxTotalFruits(fruits [][]int, startPos int, k int) int {
	maxPos := max(fruits[len(fruits)-1][0], startPos)
	records := make([]int, maxPos+1)
	ans := 0
	index := 0
	pre := 0
	for _, arr := range fruits {
		for index < arr[0] {
			records[index] = pre
			index++
		}
		pre += arr[1]
		records[index] = pre
		index++
	}
	for index < len(records) {
		records[index] = pre
		index++
	}
	fmt.Println(records)
	for l := max(0, startPos-k); l <= startPos; l++ {
		r := max(startPos, startPos+k-2*(startPos-l))
		r = min(r, len(records)-1)
		//fmt.Println(l,r)
		if l > 0 {
			ans = max(ans, records[r]-records[l-1])
		} else {
			ans = max(records[r], ans)
		}
	}
	for r := min(startPos+k, len(records)-1); r >= startPos; r-- {
		l := min(startPos, startPos-(k-2*(r-startPos)))
		l = max(0, l)
		if l > 0 {
			ans = max(ans, records[r]-records[l-1])
		} else {
			ans = max(records[r], ans)
		}
	}
	return ans
}

// @lc code=end
