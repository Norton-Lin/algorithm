package main

/*
 * @lc app=leetcode.cn id=2444 lang=golang
 *
 * [2444] 统计定界子数组的数目
 */
// 还是双指针
// @lc code=start
func CountSubarrays(nums []int, minK int, maxK int) int64 {
	var res int64
	border, last_min, last_max := -1, -1, -1
	for i := 0; i < len(nums); i++ {
		if nums[i] < minK || nums[i] > maxK {
			last_max, last_min = -1, -1
			border = i
		}
		if nums[i] == minK {
			last_min = i
		}
		if nums[i] == maxK {
			last_max = i
		}
		if last_min != -1 && last_max != -1 {
			res += int64(min(last_min, last_max) - border)
		}
	}
	return res
}

// @lc code=end
