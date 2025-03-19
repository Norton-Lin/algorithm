package main

/*
 * @lc app=leetcode.cn id=1963 lang=golang
 *
 * [1963] 使字符串平衡的最小交换次数
 */

// @lc code=start
//未匹配到的右括号需要交换
func MinSwaps(s string) int {
	//ans := 0
	left, right := 0, 0
	for _, c := range s {
		if c == '[' {
			left++
		} else {
			if left > 0 {
				left--
			} else {
				right++
			}
		}
	}
	if right%2 == 1 {
		right += 1
	}
	return right / 2
}

// @lc code=end
