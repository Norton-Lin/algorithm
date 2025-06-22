package contest455

//最多 len(numWays)
func FindCoins(numWays []int) []int {
	ans := make([]int, 0)
	for i, num := range numWays {
		cur := 0
		for j := 1; j < num/2; j++ {
			cur += numWays[i-j] + numWays[j-1]
		}
		if cur == num-1 {
			ans = append(ans, num)
		} else if cur < num-1 {
			return make([]int, 0)
		}
	}
	return ans
}
