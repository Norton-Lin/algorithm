package main

//返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
//如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。
//!不用相邻
func numberOfRightTriangles(grid [][]int) int64 {
	//枚举
	var ans int64 = 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			//找直角点
			if grid[i][j] == 1 {
				// test code
				if i > 0 {
					if grid[i-1][j] == 1 {
						if j > 0 && grid[i][j-1] == 1 {
							ans++
						}
						if j < len(grid[i])-1 && grid[i][j+1] == 1 {
							ans++
						}
					}
				}
				if i < len(grid)-1 {
					if grid[i+1][j] == 1 {
						if j > 0 && grid[i][j-1] == 1 {
							ans++
						}
						if j < len(grid[i])-1 && grid[i][j+1] == 1 {
							ans++
						}
					}
				}
			}
		}
	}
	return ans
}
