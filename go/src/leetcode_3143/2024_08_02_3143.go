package main

import (
	"math"
)

// 标签不可以重复
// 寻找距离原点最近的重复标签点的
// 记录第一个重复标签点位置
// O（n）超时
func maxPointsInsideSquare(points [][]int, s string) int {
	ans := 0
	dots := make([]int, 26)
	for i := range dots {
		dots[i] = math.MaxInt
	}
	limit := math.MaxInt
	for i, ch := range s {
		pos := int(max(math.Abs(float64(points[i][0])), math.Abs(float64(points[i][1])))) //距离原点最远距离
		j := int(ch - 'a')

		if pos < dots[j] {
			limit = min(limit, dots[j])
			dots[j] = pos
		} else if pos < limit { //一定是第二个点
			limit = pos
		}
	}
	for _, value := range dots {
		if value < limit {
			ans++
		}
	}
	return ans
}
