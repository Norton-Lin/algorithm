package contest440

func NumOfUnplacedFruits(fruits []int, baskets []int) int {
	ans := 0
	n := len(baskets)
	for _, fruit := range fruits {
		ans++
		for i := 0; i < n; i++ {
			if baskets[i] >= fruit {
				baskets[i] = 0
				ans--
				break
			}
		}
	}
	return ans
}
