package main

/*
 * @lc app=leetcode.cn id=2024 lang=golang
 *
 * [2024] 考试的最大困扰度
 */

// @lc code=start
func maxConsecutiveAnswers(answerKey string, k int) int {
	return max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'))
}

func maxConsecutiveChar(answerKey string, k int, ch byte) int {
	left, right := 0, 0
	maxLen, count := 0, 0

	for right < len(answerKey) { //每次右移一位 进行统计
		if answerKey[right] != ch {
			count++
		}
		right++

		for count > k { //左边界移动
			if answerKey[left] != ch {
				count--
			}
			left++
		}

		maxLen = max(maxLen, right-left)
	}

	return maxLen
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end
