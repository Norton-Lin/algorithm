package main

/*
 * @lc app=leetcode.cn id=2012 lang=golang
 *
 * [2012] 数组美丽值求和
 */

// @lc code=start
// 比前面都大，比后面都小 2
// 比前一个大，比后一个小 1
// 记录从右到左的最小值
// 从左到右一遍记录最大值一边计算美丽值
func SumOfBeauties(nums []int) int {
	ans := 0
	n := len(nums)
	pre := nums[n-1]
	back := make([]int, n)
	for i := n - 1; i >= 1; i-- {
		if nums[i] < pre {
			pre = nums[i]
		}
		back[i] = pre
	}
	pre = nums[0]
	for i := 1; i < n-1; i++ {
		if nums[i] > pre && nums[i] < back[i+1] {
			ans += 2
		} else if nums[i] > nums[i-1] && nums[i] < nums[i+1] {
			ans++
		}
		pre = max(pre, nums[i])
	}
	return ans
}

// @lc code=end
