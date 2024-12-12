package main

/*
 * @lc app=leetcode.cn id=2717 lang=golang
 *
 * [2717] 半有序排列
 */

// @lc code=start
func semiOrderedPermutation(nums []int) int {
	index1, index2, n := 0, 0, len(nums)
	ans := 0
	for i, num := range nums {
		if num == 1 {
			index1 = i
		}
		if num == n {
			index2 = i
		}
	}
	ans = index1 - 0 + n - 1 - index2
	if index1 > index2 {
		ans--
	}
	return ans
}

// @lc code=end
