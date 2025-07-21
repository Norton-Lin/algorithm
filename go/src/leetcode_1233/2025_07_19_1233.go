package main

import (
	"sort"
	"strings"
)

/*
 * @lc app=leetcode.cn id=1233 lang=golang
 *
 * [1233] 删除子文件夹
 */

// @lc code=start
func RemoveSubfolders(folder []string) []string {
	sort.Strings(folder)
	ans := make([]string, 0)
	cur := folder[0]
	ans = append(ans, cur)
	for _, str := range folder[1:] {
		if strings.HasPrefix(str, cur+"/") {
			continue
		} else {
			ans = append(ans, str)
			cur = str
		}
	}
	return ans
}

// @lc code=end
