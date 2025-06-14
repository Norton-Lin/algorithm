package main

/*
 * @lc app=leetcode.cn id=2434 lang=golang
 *
 * [2434] 使用机器人打印字典序最小的字符串
 */

// @lc code=start
// 一个栈
// 每次先检查栈顶，如果是最小字符，弹出当前字符
// 否则新元素入栈
// 统计最小字符，哈希或者后缀记录
func RobotWithString(s string) string {
	last := -1 //栈顶指针
	stack := make([]rune, 0)
	cIndex := 0
	records := make([]int, 26)
	ans := make([]rune, 0)
	for _, c := range s {
		records[c-'a']++
	}
	for _, c := range s {
		for records[cIndex] == 0 {
			cIndex++
		}
		records[c-'a']--
		for last >= 0 && c >= stack[last] {
			if stack[last]-'a' <= rune(cIndex) {
				ans = append(ans, stack[last])
				stack = stack[0 : len(stack)-1]
				last--
			} else {
				break
			}
		}
		if int(c-'a') <= cIndex { //最小字符
			ans = append(ans, c)
		} else {
			stack = append(stack, c)
			last++
		}
	}
	for ; last > -1; last-- {
		ans = append(ans, stack[last])
	}
	return string(ans)
}

// @lc code=end
