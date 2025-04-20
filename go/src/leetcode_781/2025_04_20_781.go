package main

/*
 * @lc app=leetcode.cn id=781 lang=golang
 *
 * [781] 森林中的兔子
 */

// @lc code=start
// 记录每个不同的answer
// 每个answer表示有answer+1个这种颜色的兔子
// (answer+answer_num)/(answer+1)表示兔子相同的颜色数
// 所有 ：颜色数*兔子 = 最终答案
func NumRabbits(answers []int) int {
	records := make([]int, 1000)
	ans := 0
	for _, num := range answers {
		records[num]++
	}
	for i, value := range records {
		ans += (i + 1) * ((value + i) / (i + 1))
	}
	return ans
}

// @lc code=end
