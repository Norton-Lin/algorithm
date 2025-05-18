package contest450

import "fmt"

// 广搜，记录到达某一点的最小距离
func minMoves(matrix []string) int {
	queue := make([]int, 0)
	records := make(map[int]int)
	jump := make(map[int]int)
	fmt.Println(jump)
	m := len(matrix)
	n := len(matrix[0])
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			records[(i+1)*10000+j] = -1
			if matrix[i][j] != '.' && matrix[i][j] != '#' {
			}
		}
	}
	queue = append(queue, (0+1)*10000+0)
	for len(queue) > 0 {
		key := queue[0]
		queue = queue[1:]
		j := key % 10000
		i := key / 10000
		fmt.Print(i, j)
	}
	return records[m*10000+n]
}
