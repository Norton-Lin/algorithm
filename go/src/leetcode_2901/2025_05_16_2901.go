package main

import "fmt"

/*
 * @lc app=leetcode.cn id=2901 lang=golang
 *
 * [2901] 最长相邻不相等子序列 II
 */

// @lc code=start
// 相邻两个字符串差别为1
//

func GetWordsInLongestSubsequence(words []string, groups []int) []string {
	ans := make([]string, 0)
	n := len(words)
	records := make([][]int, n)
	start := 0
	for i := 1; i < 11; i++ {
		for j := n - 1; j >= 0; j-- {
			if len(words[j]) != i {
				continue
			}
			l := 1
			records[j] = make([]int, 2)
			index := n
			for k := n - 1; k > j; k-- {
				if groups[j] == groups[k] || len(words[k]) != i {
					continue
				}
				diff := 0
				for cnt := 0; cnt < i; cnt++ {
					if words[j][cnt] != words[k][cnt] {
						diff++
					}
				}
				if diff != 1 {
					continue
				}
				if records[k][1] > l-1 {
					l = records[k][1] + 1
					index = k
				}
			}
			records[j][0], records[j][1] = index, l
		}
	}
	l := 1
	for i, record := range records {
		//fmt.Println(i,record[1],l)
		if record[1] > l {
			l = record[1]
			start = i
			fmt.Println(start, l)
		}
	}
	//fmt.Println(start,l)
	for start < n {
		ans = append(ans, words[start])
		start = records[start][0]
	}
	//fmt.Println(records)
	return ans
}

// @lc code=end
