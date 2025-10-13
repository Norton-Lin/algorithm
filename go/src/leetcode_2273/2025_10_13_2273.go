package main

import "sort"

/*
 * @lc app=leetcode.cn id=2273 lang=golang
 *
 * [2273] 移除字母异位词后的结果数组
 */

// @lc code=start
func RemoveAnagrams(words []string) []string {
	ans := make([]string, 0)
	cur := []rune(words[0])
	sort.Slice(cur, func(i, j int) bool {
		return cur[i] < cur[j]
	})
	ans = append(ans, words[0])
	for index, tmp := range words {
		word := []rune(tmp)
		sort.Slice(word, func(i, j int) bool {
			return word[i] < word[j]
		})
		if string(word) != string(cur) {
			ans = append(ans, words[index])
			cur = word
		}
	}
	return ans
}

// @lc code=end
