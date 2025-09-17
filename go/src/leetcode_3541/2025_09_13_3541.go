package main

/*
 * @lc app=leetcode.cn id=3541 lang=golang
 *
 * [3541] 找到频率最高的元音和辅音
 */

// @lc code=start
func MaxFreqSum(s string) int {
	cnt := make([]int, 26)
	vowel, consonant := 0, 0
	for _, c := range s {
		cnt[c-'a']++
		if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
			if vowel < cnt[c-'a'] {
				vowel = cnt[c-'a']
			}
		} else {
			if consonant < cnt[c-'a'] {
				consonant = cnt[c-'a']
			}
		}
	}
	return vowel + consonant
}

// @lc code=end
