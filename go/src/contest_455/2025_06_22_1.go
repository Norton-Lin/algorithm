package contest455

func CheckPrimeFrequency(nums []int) bool {
	records := make([]int, 101)
	ans := false
	for _, num := range nums {
		records[num]++
	}
	for _, num := range records {
		if num < 2 {
			continue
		}
		i := 2
		for ; i < num/2; i++ {
			if num%i == 0 {
				break
			}
		}
		if num%i != 0 || i >= num/2 {
			ans = true
			break
		}
	}
	return ans
}
