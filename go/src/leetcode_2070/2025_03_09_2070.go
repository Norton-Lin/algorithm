package main

import (
	"sort"
)

/*
 * @lc app=leetcode.cn id=2070 lang=golang
 *
 * [2070] 每一个查询的最大美丽值
 */

// @lc code=start
// 查价格小于query的price的最大beauty
// 二分
// 排序items
func maximumBeauty(items [][]int, queries []int) []int {
	sort.Slice(items, func(i, j int) bool {
		if items[i][0] == items[j][0] {
			return items[i][1] < items[j][1]
		}
		return items[i][0] < items[j][0]
	})
	n := len(items)
	beauty := items[0][0]
	for i := 1; i < n; i++ {
		if items[i][1] < beauty {
			items[i][1] = beauty
		} else {
			beauty = items[i][1]
		}
	}
	m := len(queries)
	ans := make([]int, m)
	for i, query := range queries {
		res := lowerbound(items, query)
		ans[i] = res
	}
	return ans
}
func lowerbound(items [][]int, query int) int {
	ans := 0
	if items[0][0] > query {
		return ans
	}
	left, right := 0, len(items)-1
	for left < right {
		mid := left + (right-left)/2 // 使用上中位数避免死循环
		if items[mid][0] < query {
			left = mid
		} else {
			right = mid - 1
		}
	}
	ans = items[left][1]

	return ans
}

// @lc code=end
