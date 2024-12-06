package main

/*
 * @lc app=leetcode.cn id=999 lang=golang
 *
 * [999] 可以被一步捕获的棋子数
 */

// @lc code=start
func NumRookCaptures(board [][]byte) int {
	pos := make([]int, 2)
	ans := 0
	for i := 0; i < 8; i++ {
		for j := 0; j < 8; j++ {
			if board[i][j] == 'R' {
				pos = []int{i, j}
			}
		}
	}
	for i := pos[0] + 1; i < 8; i++ {
		if board[i][pos[1]] == 'p' {
			ans++
			break
		} else if board[i][pos[1]] == 'B' {
			break
		}
	}
	for i := pos[0] - 1; i >= 0; i-- {
		if board[i][pos[1]] == 'p' {
			ans++
			break
		} else if board[i][pos[1]] == 'B' {
			break
		}
	}
	for j := pos[1] + 1; j < 8; j++ {
		if board[pos[0]][j] == 'p' {
			ans++
			break
		} else if board[pos[0]][j] == 'B' {
			break
		}
	}
	for j := pos[1] - 1; j >= 0; j-- {
		if board[pos[0]][j] == 'p' {
			ans++
			break
		} else if board[pos[0]][j] == 'B' {
			break
		}
	}
	return ans
}

// @lc code=end
