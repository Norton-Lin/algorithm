package main

/*
 * @lc app=leetcode.cn id=909 lang=golang
 *
 * [909] 蛇梯棋
 */

// @lc code=start
// bfs
// 每个点位置坐标为 (i,j)
// 对应号码为 (n - i - 1) * n + j + 1 i%2 == (n-1)%2
//
//	(n - i)*n - j  i%2 == n % 2
//
// 遇到梯子直接跳转
func SnakesAndLadders(board [][]int) int {
	n := len(board)
	ans := n*n + 1
	visited := make([]bool, n*n+1)
	queue := make([][]int, 0)
	queue = append(queue, []int{1, 0})
	visited[1] = true
	for len(queue) > 0 {
		cur := queue[0]
		queue = queue[1:]
		//fmt.Println(cur)
		if cur[0] == n*n {
			ans = min(ans, cur[1])
		}
		for k := cur[0] + 1; k < cur[0]+7 && k < len(visited); k++ {
			i, j := getLocation(k, n)
			next := k
			if board[i][j] != -1 {
				next = board[i][j]
			}
			if !visited[next] {
				visited[next] = true
				queue = append(queue, []int{next, cur[1] + 1})
			}
			//fmt.Println(queue)
		}
	}
	if ans == n*n+1 {
		ans = -1
	}
	return ans
}
func getNum(i, j, n int) int {
	ans := 0
	if i%2 == n%2 {
		ans = (n-i)*n - j
	} else {
		ans = (n-i-1)*n + j + 1
	}
	return ans
}
func getLocation(num, n int) (int, int) {
	i := n - (num-1)/n - 1
	j := 0
	if i%2 == n%2 {
		j = (n-i)*n - num
	} else {
		j = num - (n-i-1)*n - 1
	}
	return i, j
}

// @lc code=end
