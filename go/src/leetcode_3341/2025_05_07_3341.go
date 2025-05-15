package main

import "fmt"

func MinTimeToReach(moveTime [][]int) int {
	n, m := len(moveTime), len(moveTime[0])
	moveTime[0][0]--
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			cur1, cur2 := moveTime[i][j], moveTime[i][j]
			if i > 0 {
				if moveTime[i-1][j] >= cur1 {
					cur1 = moveTime[i-1][j]
				}
			}
			if j > 0 {
				if moveTime[i][j-1] >= cur2 {
					cur2 = moveTime[i][j-1]
				}
			}
			cur := min(cur1, cur2)
			moveTime[i][j] = max(moveTime[i][j], cur) + 1
			fmt.Println(moveTime, cur1, cur2)
		}
	}
	fmt.Println(moveTime)
	return moveTime[n-1][m-1]
}
