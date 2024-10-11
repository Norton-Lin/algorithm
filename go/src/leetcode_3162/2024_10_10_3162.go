package main

/*
 * @lc app=leetcode.cn id=3162 lang=golang
 *
 * [3162] 优质数对的总数 I
 */

// @lc code=start
func NumberOfPairs(nums1 []int, nums2 []int, k int) int {
	ans := 0
	for _, i := range nums1 {
		for _, j := range nums2 {
			if i%(j*k) == 0 {
				ans++
			}
		}
	}
	return ans
}

// @lc code=end
