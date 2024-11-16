package main

/*
 * @lc app=leetcode.cn id=3240 lang=golang
 *
 * [3240] 最少翻转次数使二进制矩阵回文 II
 */

// @lc code=start
func MinFlips(grid [][]int) int {
	n, m := len(grid), len(grid[0])
	ans := 0
	// 横坐标
	// 纵坐标
	i, j := 0, n-1
	l, r := 0, m-1
	num := 0    //记录变化数
	record := 0 //1数
	for i < j {
		l, r = 0, m-1
		for l < r {
			cur := grid[i][l] + grid[i][r] + grid[j][l] + grid[j][r]
			if cur%4 != 0 {
				ans += min(cur, 4-cur)
			}
			l++
			r--
		}
		i++
		j--
	}
	// 奇数行
	if i == j {
		l, r = 0, m-1
		for l < r {
			cur := grid[i][l] + grid[i][r]
			if cur%2 != 0 {
				num++
			}
			if grid[i][l] == 1 {
				record += 2
			}
			l++
			r--
		}
	}
	if l == r {
		i, j := 0, n-1
		for i < j {
			cur := grid[i][l] + grid[j][l]
			if cur%2 != 0 {
				num++
			}
			if grid[i][l] == 1 {
				record += 2
			}
			i++
			j--
		}
	}
	if record%4 != 0 && num == 0 {
		num += 2
	}
	if n%2 == 1 && m%2 == 1 && grid[n/2][m/2] == 1 {
		ans++
	}
	return ans + num
}

// @lc code=end
