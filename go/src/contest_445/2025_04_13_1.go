package contest445

import "math"

func FindClosest(x int, y int, z int) int {
	ans := 0
	diff1, diff2 := int(math.Abs(float64(z-x))), int(math.Abs(float64((z - y))))
	if diff1 > diff2 {
		ans = 2
	} else if diff1 < diff2 {
		ans = 1
	}
	return ans
}
