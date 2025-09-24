package main

import (
	"strconv"
)

/*
 * @lc app=leetcode.cn id=166 lang=golang
 *
 * [166] 分数到小数
 */

// @lc code=start
func FractionToDecimal(numerator int, denominator int) string {
	if numerator == 0 {
		return "0"
	}

	records := make(map[int]int)
	demical := make([]rune, 0) //小数部分
	res := ""
	if numerator < 0 != (denominator < 0) {
		res += "-"
	}
	if numerator < 0 {
		numerator = -numerator
	}
	if denominator < 0 {
		denominator = -denominator
	}
	// 先整数，后小数
	integer := numerator / denominator
	res += strconv.Itoa(integer)
	num := numerator % denominator
	if num == 0 {
		return res
	} else {
		res += "."
	}
	// 小数
	for numerator > denominator {
		numerator /= 10
	}
	for num != 0 && records[num] == 0 {
		records[num] = len(demical)
		num *= 10
		demical = append(demical, rune(num/denominator)+'0')
		num = num % denominator
	}
	if num == 0 {
		res += string(demical)
	} else {
		index := records[num]
		res += string(demical[0:index]) + "(" + string(demical[index:]) + ")"
	}
	return res
}

// @lc code=end
