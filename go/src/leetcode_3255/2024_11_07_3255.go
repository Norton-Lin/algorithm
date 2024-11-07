package main

/*
 * @lc app=leetcode.cn id=3255 lang=golang
 *
 * [3255] 长度为 K 的子数组的能量值 II
 */

// @lc code=start
// 一个中断接下来k个中断
// 上一个连续，新数字也连续，新数组连续
// if dp[i-1] != -1 && nums[i+k] == nums[i-1]+k+1
// dp[i] = do[i-1]+1
// else dp[i] = -1
func ResultsArray(nums []int, k int) []int {
	n := len(nums)
	ans := make([]int, n-k+1)
	prev := nums[0] // 递增终点
	start := 0
	i := 1
	// 长度为1就是原数组
	if k == 1 {
		return nums
	}
	for ; i < k; i++ {
		if prev != nums[i]-1 {
			start = i
			ans[0] = -1
		}
		prev = nums[i]
	}
	if ans[0] != -1 {
		ans[0] = prev
	}
	for ; i < n; i++ {
		// 不连续递增 -1 记录中断
		if prev != nums[i]-1 {
			start = i
			ans[i-k+1] = -1
		} else {
			// 连续递增就看连续长度
			if i-start >= k-1 {
				ans[i-k+1] = nums[i]
			} else {
				ans[i-k+1] = -1
			}
		}
		prev = nums[i]
	}
	return ans
}

// @lc code=end
