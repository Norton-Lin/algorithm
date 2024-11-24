package main

import "sort"

/*
 * @lc app=leetcode.cn id=632 lang=golang
 *
 * [632] 最小区间
 */

// @lc code=start
// 构建滑动窗口？
// 全数组最大长度不超过20w 可以
func SmallestRange(nums [][]int) []int {
	record := make([][]int, 0)
	n := len(nums)
	own := make([]int, n)
	num := 0
	cur := []int{0, 0}
	for i, num := range nums {
		for _, j := range num {
			record = append(record, []int{j, i})
		}
	}
	m := len(record)
	sort.Slice(record, func(i, j int) bool {
		return record[i][0] < record[j][0]
	})
	ans := []int{record[0][0], record[m-1][0]}
	for cur[1] <= m {
		if num < n {
			if cur[1] == m {
				break
			}
			if own[record[cur[1]][1]] == 0 {
				num++
			}
			own[record[cur[1]][1]]++
			cur[1]++
		} else {
			if record[cur[1]-1][0]-record[cur[0]][0] < ans[1]-ans[0] {
				ans[0] = record[cur[0]][0]
				ans[1] = record[cur[1]-1][0]
			}
			cur[0]++
			own[record[cur[0]-1][1]]--
			if own[record[cur[0]-1][1]] == 0 {
				num--
			}
		}
	}
	return []int{ans[0], ans[1]}
}

// @lc code=end
