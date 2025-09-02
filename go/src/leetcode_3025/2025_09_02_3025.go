package main

import "sort"

/*
 * @lc app=leetcode.cn id=3025 lang=golang
 *
 * [3025] 人员站位的方案数 I
 */

// @lc code=start
// 排序，然后扫一遍
func NumberOfPairs(points [][]int) int {
	ans := 0
	sort.Slice(points, func(i, j int) bool {
		if points[i][0] == points[j][0] {
			return points[i][1] > points[j][1]
		}
		return points[i][0] < points[j][0]
	})
	//fmt.Println(points)
	for l, a := range points {
		for r, b := range points[l+1:] {
			if b[1] > a[1] {
				continue
			}
			flag := true
			//fmt.Println(a,b)
			for _, c := range points[l+1 : l+r+1] {
				if c[1] <= a[1] && c[1] >= b[1] {
					flag = false
					break
				}
			}
			if flag {
				ans++
			}
		}
	}
	return ans
}

// @lc code=end
