package main

/*
 * @lc app=leetcode.cn id=904 lang=golang
 *
 * [904] 水果成篮
 */

// @lc code=start
// 滑动窗口，窗口内只有两个元素
func TotalFruit(fruits []int) int {
	ans := 0
	fruit1 := fruits[0]
	num1 := 1
	fruit2 := -1
	num2 := 0
	index := 1
	for ; index < len(fruits); index++ {
		if fruits[index] == fruit1 {
			num1++
		} else {
			fruit2 = fruits[index]
			num2 = 1
			break
		}
	}
	ans = num1 + num2
	for l, r := 0, index+1; r < len(fruits); r++ {
		if fruit1 == fruits[r] {
			num1++
		} else if fruit2 == fruits[r] {
			num2++
		} else {
			for ; l < r-1 && num2 != 0; l++ {
				if fruit1 == fruits[l] {
					num1--
				} else {
					num2--
				}
				if num1 == 0 {
					fruit1 = fruit2
					num1 = num2
					num2 = 0
				}
			}
			fruit2 = fruits[r]
			num2 = 1
		}
		ans = max(num1+num2, ans)
	}

	return ans
}

// @lc code=end
