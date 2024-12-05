package main

import "math"

/*
 * @lc app=leetcode.cn id=3001 lang=golang
 *
 * [3001] 捕获黑皇后需要的最少移动次数
 */

// @lc code=start
//最多两次
func MinMovesToCaptureTheQueen(a int, b int, c int, d int, e int, f int) int {
	ans := 2
	// 车和皇后在同一条直线上
	if a == e || b == f {
		ans = 1
		if a == e && c == e {
			if b < d && d < f {
				ans = 2
			} else if f < d && d < b {
				ans = 2
			}
		} else if b == f && d == f {
			if a < c && c < e {
				ans = 2
			} else if e < c && c < a {
				ans = 2
			}
		}
		// 象和皇后在同一对角线上
	} else if int(math.Abs(float64(c-e))) == int(math.Abs(float64(d-f))) {
		ans = 1
		row := (c - e) / (int(math.Abs(float64(c - e))))
		col := (d - f) / int(math.Abs(float64(d-f)))
		for c != e {
			c -= row
			d -= col
			if c == a && d == b {
				ans = 2
				break
			}
		}

	}
	return ans
}

// @lc code=end
