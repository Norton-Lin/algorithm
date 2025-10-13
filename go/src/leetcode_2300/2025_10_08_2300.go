package main

import "sort"

/*
 * @lc app=leetcode.cn id=2300 lang=golang
 *
 * [2300] 咒语和药水的成功对数
 */

// @lc code=start
func SuccessfulPairs(spells []int, potions []int, success int64) []int {
	ans := make([]int, len(spells))
	n := len(potions)
	sort.Ints(potions)
	for index, num := range spells {
		value := int(success / int64(num))
		if success%int64(num) != 0 {
			value++
		}
		ans[index] = n - sort.SearchInts(potions, value)
	}
	return ans
}

// @lc code=end
