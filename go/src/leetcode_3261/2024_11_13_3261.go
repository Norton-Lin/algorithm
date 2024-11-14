package main

/*
 * @lc app=leetcode.cn id=3261 lang=golang
 *
 * [3261] 统计满足 K 约束的子字符串数量 II
 */

// @lc code=start
func countKConstraintSubstrings(s string, k int, queries [][]int) []int64 {
	n := len(s)
	right := make([]int, n)
	sum := make([]int, n+1)
	cnt := [2]int{}
	l := 0
	for i, c := range s {
		cnt[c&1]++
		for cnt[0] > k && cnt[1] > k {
			cnt[s[l]&1]--
			right[l] = i
			l++
		}
		sum[i+1] = sum[i] + i - l + 1
	}
	// 剩余没填的 right[l] 均为 n
	for ; l < n; l++ {
		right[l] = n
	}

	ans := make([]int64, len(queries))
	for i, q := range queries {
		l, r := q[0], q[1]
		j := min(right[l], r+1)
		ans[i] = int64(sum[r+1] - sum[j] + (j-l+1)*(j-l)/2)
	}
	return ans
}

// @lc code=end
