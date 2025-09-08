package main

/*
 * @lc app=leetcode.cn id=1317 lang=golang
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
func GetNoZeroIntegers(n int) []int {
	ans := make([]int, 2)
	flag := true
	for i := 1; flag && i <= n/2; i++ {
		flag = false
		for j := i; j > 0; j /= 10 {
			if j%10 == 0 {
				flag = true
				break
			}
		}
		for j := n - i; j > 0; j /= 10 {
			if j%10 == 0 {
				flag = true
				break
			}
		}
		ans[0] = i
	}
	ans[1] = n - ans[0]
	return ans
}

// @lc code=end
