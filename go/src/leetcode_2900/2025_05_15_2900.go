package main

/*
 * @lc app=leetcode.cn id=2900 lang=golang
 *
 * [2900] 最长相邻不相等子序列 I
 */

// @lc code=start
func GetLongestSubsequence(words []string, groups []int) (ans []string) {
	ans1 := make([]string, 0)
	ans2 := make([]string, 0)

	n := len(groups)
	tag := 0
	for i := 0; i < n; i++ {
		if groups[i] == tag {
			ans1 = append(ans1, words[i])
			tag = (tag + 1) % 2
		}
	}
	tag = 1
	for i := 0; i < n; i++ {
		if groups[i] == tag {
			ans2 = append(ans2, words[i])
			tag = (tag + 1) % 2
		}
	}
	if len(ans1) > len(ans2) {
		ans = ans1
	} else {
		ans = ans2
	}
	return ans
}

// @lc code=end
