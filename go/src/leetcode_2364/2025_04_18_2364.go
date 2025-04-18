package main

/*
 * @lc app=leetcode.cn id=2364 lang=golang
 *
 * [2364] 统计坏数对的数目
 */

// @lc code=start
// 总数量 n*(n-1)/2
// 如果 nums[i]>nums[j]一定是坏数对
// 如果 i，j是好数对 j，k是好数对 i j k是好数对
// i - nums[i] == j- nums[j]
// 找好数对
// 坏数对 = 总数量 - 好数对
func CCountBadPairs(nums []int) int64 {
	records := make(map[int]int64)
	ans := int64(0)
	n := int64(len(nums))
	for i, num := range nums {
		ans += records[num-i]
		records[num-i]++
	}
	return n*(n-1)/2 - ans
}

// @lc code=end
