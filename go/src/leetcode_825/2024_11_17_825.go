package main

/*
 * @lc app=leetcode.cn id=825 lang=golang
 *
 * [825] 适龄的朋友
 */

// @lc code=start
// 当 ages[y] > 0.5*age[x]+7 &&
// ages[y]<= ages[x] &&
// (ages[y]<=100 || ages[x] >=100)
// x y 构建连接
// ages只有120个
func NumFriendRequests(ages []int) int {
	ans := 0
	values := make([]int, 121)
	for _, age := range ages {
		values[age]++
	}
	for y := 0; y < 121; y++ {
		ans += values[y] * (values[y] - 1)
		for x := y + 1; x < 121; x++ {
			if (2*ages[y] > ages[x]+14) && (ages[y] <= 100 || ages[x] >= 100) {
				ans += values[x] * values[y]
			}
		}
	}

	return ans
}

// @lc code=end
