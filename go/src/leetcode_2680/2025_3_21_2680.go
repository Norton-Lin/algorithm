package main

/*
 * @lc app=leetcode.cn id=2680 lang=golang
 *
 * [2680] 最大或值
 */

// @lc code=start
// 2^m ~2^(m+1)的都可以成为左移目标
// 前缀和
func MaximumOr(nums []int, k int) int64 {
	ans := int64(0)
	cur := int64(0)
	n := len(nums)
	left := make([]int64, n)  //前0-i-1的或
	right := make([]int64, n) //后n-1~i的或
	left[0], right[n-1] = 0, 0
	for i := 1; i < n; i++ {
		left[i] = left[i-1] | int64(nums[i-1])
		right[n-i-1] = right[n-i] | int64(nums[n-i])
	}
	for i := 0; i < n; i++ {
		cur = left[i] | right[i] | (int64(nums[i]) << k)
		ans = max(cur, ans)
	}
	return ans
}

// @lc code=end
