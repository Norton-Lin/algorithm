package main

/*
 * @lc app=leetcode.cn id=2845 lang=golang
 *
 * [2845] 统计趣味子数组的数目
 */

// @lc code=start
// 前缀和 假设cnt[i]为0-l范围内满足 nums[i] % modulo == i 的索引的数量
// pre为当前前缀和
// 若 i == k ，满足
// 若  i ！= k  求x,k == pre+module - x %module
func CountInterestingSubarrays(nums []int, modulo int, k int) int64 {
	records := make(map[int64]int64)
	ans := int64(0)
	records[0] = 1
	pre := int64(0)
	for _, num := range nums {
		cur := int64(num % modulo)
		if cur == int64(k) {
			pre++
		}
		ans += records[(pre-int64(k)+int64(modulo))%int64(modulo)]
		records[pre%int64(modulo)]++
	}
	return ans
}

// @lc code=end
