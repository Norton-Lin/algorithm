package main

import (
	"sort"
)

/*
 * @lc app=leetcode.cn id=2563 lang=golang
 *
 * [2563] 统计公平数对的数目
 */

// @lc code=start
// lower <= nums[i] + nums[j] <= upper
// 0<=i<j<n
// i,j 是公平数对
// 排序双指针，两个指针每次从上次的位置偏移即可
func CountFairPairs(nums []int, lower int, upper int) int64 {
	sort.Ints(nums)
	n := len(nums)
	left, right := 0, 0
	ans := int64(0)
	for left < n && nums[0]+nums[left] < lower {
		left++
	}
	right = left
	// right 最大为n
	for right < n && nums[0]+nums[right] <= upper {
		right++
	}
	ans += int64(right - left)
	if left == n {
		ans = 0
		left = n - 1
	}
	for i := 1; i < n; i++ {
		for left >= 0 && nums[i]+nums[left] >= lower {
			left--
		}
		left++
		if right == n {
			right--
		}
		for right >= left && nums[i]+nums[right] > upper {
			right--
		}
		right++
		if left == n {
			left = n - 1
			continue
		} else if i >= left && i < right {
			ans--
		}
		ans += int64(right - left)
		//fmt.Println(i, left, right, ans)
	}
	return ans / 2
}

// @lc code=end
