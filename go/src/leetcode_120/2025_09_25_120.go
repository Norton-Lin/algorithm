package main

import "math"

/*
 * @lc app=leetcode.cn id=120 lang=golang
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
func MinimumTotal(triangle [][]int) int {
	n := len(triangle)
	cur := make([]int, n)
	pre := make([]int, n)
	for i := 0; i < n; i++ {
		cur[i], pre[i] = 100001, 100001
	}
	pre[0], cur[0] = triangle[0][0], triangle[0][0]
	ans := math.MaxInt
	for i := 1; i < n; i++ {
		//fmt.Println(cur,pre)
		cur[0] = pre[0] + triangle[i][0]
		for j := 1; j <= i; j++ {
			cur[j] = triangle[i][j] + min(pre[j], pre[j-1])
		}
		for j := 0; j <= i; j++ {
			pre[j] = cur[j]
		}

	}
	//mt.Println(cur,pre)
	for _, num := range cur {
		ans = min(num, ans)
	}
	return ans
}

// @lc code=end
