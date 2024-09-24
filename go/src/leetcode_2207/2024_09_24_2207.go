package main

/*
 * @lc app=leetcode.cn id=2207 lang=golang
 *
 * [2207] 字符串中最多数目的子序列
 */

// @lc code=start
// pattern[0]尽可能往前插，pattern[1]尽可能往后
// 记录pattern[0] 数量 时间 O(2*n) , 空间 O(n)
// 滚动记录，优化时空间负载度 时间 O(n), 空间 O(1)
func MaximumSubsequenceCount(text string, pattern string) int64 {
	ans, cnt1, cnt2 := int64(0), int64(0), int64(0)
	for _, i := range text {
		if byte(i) == pattern[1] {
			ans += cnt1
			cnt2++
		}
		if byte(i) == pattern[0] {
			cnt1++
		}
	}
	return ans + max(cnt1, cnt2)
}

// @lc code=end
