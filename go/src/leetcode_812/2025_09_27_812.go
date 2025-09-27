package main

import "math"

/*
 * @lc app=leetcode.cn id=812 lang=golang
 *
 * [812] 最大三角形面积
 */

// @lc code=start
//s^2=p*(p-a)(p-b)(p-c) p == (a+b+c)/2
func LargestTriangleArea(points [][]int) float64 {
	ans := float64(0)
	cur := float64(0)
	for i := 0; i < len(points)-2; i++ {
		for j := i + 1; j < len(points)-1; j++ {
			a := distance(points[i], points[j])
			for k := j + 1; k < len(points); k++ {
				b := distance(points[i], points[k])
				c := distance(points[j], points[k])
				p := (a + b + c) / 2
				cur = p * (p - a) * (p - b) * (p - c)
				ans = math.Max(ans, cur)
			}
		}
	}
	return math.Sqrt(ans)
}
func distance(a, b []int) float64 {
	return math.Sqrt(math.Pow((float64(a[0]-b[0])), 2) + math.Pow(float64(a[1]-b[1]), 2))
}

// @lc code=end
