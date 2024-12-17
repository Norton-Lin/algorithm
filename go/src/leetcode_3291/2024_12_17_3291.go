package main

import (
	"math"
)

/*
 * @lc app=leetcode.cn id=3291 lang=golang
 *
 * [3291] 形成目标字符串需要的最少字符串数 I
 */

// @lc code=start
// dp[i] 长度为前i的target 要多少个字符串数量
// dp[i+1...j] 和某个word prefix相同 dp[i+1...j] = min(dp[i+1....j],dp[i]+1)
// kmp + 递归
func MinValidStrings(words []string, target string) int {
	prefixFunction := func(word, target string) []int {
		s := word + "#" + target
		n := len(s)
		pi := make([]int, n)
		for i := 1; i < n; i++ {
			j := pi[i-1]
			for j > 0 && s[i] != s[j] {
				j = pi[j-1]
			}
			if s[i] == s[j] {
				j++
			}
			pi[i] = j
		}
		return pi
	}

	n := len(target)
	back := make([]int, n)
	for _, word := range words {
		pi := prefixFunction(word, target)
		m := len(word)
		for i := 0; i < n; i++ {
			back[i] = int(math.Max(float64(back[i]), float64(pi[m+1+i])))
		}
	}

	dp := make([]int, n+1)
	for i := 1; i <= n; i++ {
		dp[i] = int(1e9)
	}
	for i := 0; i < n; i++ {
		dp[i+1] = dp[i+1-back[i]] + 1
		if dp[i+1] > n {
			return -1
		}
	}
	return dp[n]
}

// @lc code=end
