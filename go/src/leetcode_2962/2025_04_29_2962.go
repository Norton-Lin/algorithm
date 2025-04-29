package main

/*
 * @lc app=leetcode.cn id=2962 lang=golang
 *
 * [2962] 统计最大元素出现至少 K 次的子数组
 */

// @lc code=start
// 滑动窗口 left - right 中至少有k次最大元素
// 则 任意 j >= right ,left - j 都至少有k次最大元素
// 左移一次left,右移right,知道 left - right  中至少有k次最大元素
func CountSubarrays(nums []int, k int) int64 {
	ans := int64(0)
	n := len(nums)
	mn := 0
	for _, num := range nums {
		if mn < num {
			mn = num
		}
	}
	cur := 0 //窗口最大值的数量
	left, right := 0, 0
	for ; left < n; left++ {
		for ; right < n && cur < k; right++ {
			if nums[right] == mn {
				cur++
			}
		}
		if cur >= k {
			ans += int64(n - right + 1)
		}
		if nums[left] == mn {
			cur--
		}
	}
	return ans
}

// @lc code=end
