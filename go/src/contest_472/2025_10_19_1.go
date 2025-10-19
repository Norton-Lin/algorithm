package contest472

func MissingMultiple(nums []int, k int) int {
	records := make(map[int]bool)
	for _, num := range nums {
		records[num] = true
	}
	ans := k
	for ; ans < 101; ans += k {
		if _, ok := records[ans]; !ok {
			break
		}
	}
	return ans
}
