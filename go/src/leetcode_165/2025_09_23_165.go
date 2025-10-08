package main

import (
	"strconv"
	"strings"
)

/*
 * @lc app=leetcode.cn id=165 lang=golang
 *
 * [165] 比较版本号
 */

// @lc code=start
func CompareVersion(version1 string, version2 string) int {
	ver1 := strings.Split(version1, ".")
	ver2 := strings.Split(version2, ".")
	ans := 0
	l1, l2 := len(ver1), len(ver2)
	for ; l1 < l2; l1++ {
		ver1 = append(ver1, "")
	}
	for ; l2 < l1; l2++ {
		ver2 = append(ver2, "")
	}
	l := max(l1, l2)
	for i := 0; i < l; i++ {
		cur1, cur2 := ver1[i], ver2[i]
		for len(cur1) > 0 && cur1[0] == '0' {
			cur1 = cur1[1:]
		}
		for len(cur2) > 0 && cur2[0] == '0' {
			cur2 = cur2[1:]
		}
		num1, _ := strconv.Atoi(cur1)
		num2, _ := strconv.Atoi(cur2)
		if num1 < num2 {
			ans = -1
			break
		} else if num1 > num2 {
			ans = 1
			break
		}

	}
	return ans
}

// @lc code=end
