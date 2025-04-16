package main

/*
 * @lc app=leetcode.cn id=2537 lang=golang
 *
 * [2537] 统计好子数组的数目
 */

// @lc code=start
// k对数匹配，即为好数组
// 记录从i开始 j结束的好数组数量
// j找到后，新结束下标比j大的子数组都是好数组
// 双指针 ，循环左移两个指针
// O(2n)
func CountGood(nums []int, k int) int64 {
	ans := int64(0)
	n := len(nums)
	records := make(map[int]int)
	cur := 0
	j := 0
	for i := 0; i < n; i++ {
		if cur < k && j >= n {
			break
		}
		for ; j < n; j++ {
			if cur >= k {
				break
			}
			if records[nums[j]] > 0 {
				cur += records[nums[j]]
			}
			records[nums[j]]++
		}
		if cur >= k {
			ans += int64(n - j + 1)
		}
		records[nums[i]]--
		cur -= records[nums[i]]
	}
	return ans
}

// @lc code=end
