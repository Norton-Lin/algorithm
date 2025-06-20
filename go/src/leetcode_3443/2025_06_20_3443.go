package main

func MaxDistance(s string, k int) int {
	ans := 0
	records := make([]int, 4)
	x, y := 0, 0
	for _, c := range s {
		switch c {
		case 'S':
			records[1]++
		case 'E':
			records[2]++
		case 'W':
			records[3]++
		default:
			records[0]++
		}

		x = max(records[0], records[1]) + max(records[2], records[3])
		y = min(records[0], records[1]) + min(records[2], records[3])
		ans = max(ans, x-y+2*(min(y, k)))

	}
	return ans
}
