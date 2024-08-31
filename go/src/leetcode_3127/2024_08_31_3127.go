package main

/*
 * @lc app=leetcode.cn id=3127 lang=golang
 *
 * [3127] 构造相同颜色的正方形
 */

// @lc code=start
// 出现三个颜色相同的格子，构成一个直角，就可以构成一个2*2颜色相同的正方形
func CanMakeSquare(grid [][]byte) bool {
	// Helper function to check if a 2x2 square is of the same color
	checkSquare := func(i, j int, color byte) bool {
		return grid[i][j] == color && grid[i][j+1] == color &&
			grid[i+1][j] == color && grid[i+1][j+1] == color
	}

	// Check if there's already a 2x2 square of the same color
	for i := 0; i < 2; i++ {
		for j := 0; j < 2; j++ {
			if checkSquare(i, j, grid[i][j]) {
				return true
			}
		}
	}

	// Try changing each cell and check if it forms a 2x2 square
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			original := grid[i][j]
			grid[i][j] = 'B' + 'W' - original // Flip the color

			// Check all possible 2x2 squares that include this cell
			for r := max(0, i-1); r < min(2, i+1); r++ {
				for c := max(0, j-1); c < min(2, j+1); c++ {
					if checkSquare(r, c, grid[r][c]) {
						return true
					}
				}
			}

			grid[i][j] = original // Revert the change
		}
	}
	return false
}

// @lc code=end
