package main

/*
 * @lc app=leetcode.cn id=2269 lang=golang
 *
 * [2269] 找到一个数字的 K 美丽值
 */

// @lc code=start

// 字符串长度为k，能整除num
func DivisorSubstrings(num int, k int) int {
	ans := 0
	mod := 1
	for i := 0; i < k; i++ {
		mod *= 10
	}
	value := num
	for num >= mod/10 { //位数小于k
		cur := num % mod
		num /= 10
		if cur == 0 { //0不能整除
			continue
		}
		if value%cur == 0 { //可以整除
			ans++
		}
	}
	return ans
}

// @lc code=end
