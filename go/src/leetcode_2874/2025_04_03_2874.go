package main

/*
 * @lc app=leetcode.cn id=2874 lang=golang
 *
 * [2874] 有序三元组中的最大值 II
 */

// @lc code=start
// 见 2873
func MaximumTripletValue(nums []int) int64 {
	ans := int64(0)
	diff := int64(0)
	pre := int64(0)
	for _, x := range nums {
		ans = max(ans, diff*int64(x))
		diff = max(diff, pre-int64(x))
		pre = max(pre, int64(x))
	}
	return ans
}

// @lc code=end
