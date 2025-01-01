package main

import (
	"strconv"
	"strings"
)

/*
 * @lc app=leetcode.cn id=3280 lang=golang
 *
 * [3280] 将日期转换为二进制表示
 */

// @lc code=start
// 二进制转换
func ConvertDateToBinary(date string) string {
	numstr := strings.Split(date, "-")
	ans := ""
	for _, str := range numstr {
		num, _ := strconv.Atoi(str)
		ans += strconv.FormatInt(int64(num), 2) + "-"
	}
	return ans[0 : len(ans)-1]
}

// @lc code=end
