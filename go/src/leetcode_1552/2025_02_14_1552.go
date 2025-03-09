package main

import (
	"sort"
)

/*
 * @lc app=leetcode.cn id=1552 lang=golang
 *
 * [1552] 两球之间的磁力
 */

// @lc code=start
// 投入m个点，使两两间差值最大
// 二分查找
func placePos(position []int, m int, dist int) bool {
	cnt := 1
	prev := position[0]
	for i := 1; i < len(position); i++ {
		if position[i]-prev >= dist {
			cnt++
			prev = position[i]
			if cnt == m {
				break
			}
		}
	}
	return cnt == m
}
func MaxDistance(position []int, m int) int {
	n := len(position)
	sort.Ints(position)
	// sort.Search 快速二分
	ans := sort.Search((position[n-1]-position[0])/(m-1), func(dist int) bool {
		cnt := 1
		dist++ // mid + 1
		prev := position[0]
		for i := 1; i < len(position); i++ {
			if position[i]-prev >= dist {
				cnt++
				prev = position[i]
			}
		}
		return cnt < m
	})
	// left, right := 1, position[n-1]-position[0]

	// for left <= right {
	// 	// 能放 扩大
	// 	mid := (left + right) / 2
	// 	if placePos(position, m, mid) {
	// 		left = mid + 1
	// 		ans = mid
	// 	} else {
	// 		right = mid - 1
	// 	}
	// }
	return ans
}

// @lc code=end
