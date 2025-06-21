package main

import (
	"sort"
)

/*
 * @lc app=leetcode.cn id=3085 lang=golang
 *
 * [3085] 成为 K 特殊字符串需要删除的最少字符数
 */

// @lc code=start
func MinimumDeletions(word string, k int) int {
	records := make([]int, 26)
	n := len(word)
	prefix := make([]int, 27)
	ans := max(n-k, 0)
	for _, c := range word {
		records[c-'a']++
	}
	sort.Ints(records)
	for i, num := range records {
		prefix[i+1] = prefix[i] + num
	}
	for i := 1; i < 27; i++ {
		cur := records[i-1]
		if cur == 0 {
			continue
		}
		j1 := i
		for ; j1 < 26 && records[j1]-cur <= k; j1++ {
			// fmt.Println(j1, records[j1], cur)
		}
		value := prefix[i-1] + prefix[26] - prefix[j1] - (cur+k)*(26-j1)
		//fmt.Println(i,j1,records,prefix,value)
		ans = min(ans, value)
	}
	return ans
}

// @lc code=end
