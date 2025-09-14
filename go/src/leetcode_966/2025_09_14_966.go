package main

import "strings"

/*
 * @lc app=leetcode.cn id=966 lang=golang
 *
 * [966] 元音拼写检查器
 */

// @lc code=start
func Spellchecker(wordlist []string, queries []string) []string {
	records := make(map[string]int)
	recordslow := make(map[string]int)
	set := make(map[string]bool)
	ans := make([]string, 0)
	for index, word := range wordlist {
		set[word] = true
		word = strings.ToLower(word)
		if _, ok := recordslow[word]; !ok {
			recordslow[word] = index
		}
		str := make([]rune, 0)
		for _, c := range word {
			if c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' {
				str = append(str, c)
			} else {
				str = append(str, ' ')
			}
		}
		word = string(str)
		if _, ok := records[word]; !ok {
			records[word] = index
		}
	}
	for _, word := range queries {
		if set[word] {
			ans = append(ans, word)
		} else {
			word = strings.ToLower(word)
			//fmt.Println(word)
			if _, ok := recordslow[word]; ok {
				ans = append(ans, wordlist[recordslow[word]])
				continue
			}
			str := make([]rune, 0)
			for _, c := range word {
				if c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' {
					str = append(str, c)
				} else {
					str = append(str, ' ')
				}
			}
			word = string(str)
			if _, ok := records[word]; ok {
				ans = append(ans, wordlist[records[word]])
			} else {
				ans = append(ans, "")
			}
		}
	}
	return ans
}

// @lc code=end
