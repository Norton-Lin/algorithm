package main

import "strings"

//最长字符串不一定是最长字典序
func AnswerString(word string, numFriends int) string {
	// 特殊情况，否则最长字典序的第一个字符一定是字典序最大的字符
	if numFriends == 1 {
		return word
	}

		n := len(word)
	l := n - numFriends + 1 //可以获得的最长字符串，即为答案字符串的长度,但不一定是最长
	c := byte('a')
	ans := word[:l]
	for i := 0; i < n; i++ {
		if word[i] > c {
			c = word[i]
		}
		if word[i] == c {
			cur := word[i:min(i+l, n)]
			if strings.Compare(ans, cur) < 0 {
				ans = cur
			}
		}
	}
	return ans
}
