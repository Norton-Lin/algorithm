package contest441

func MaxSum(nums []int) int {
	ans := 0
	cur := -101
	record := make(map[int]bool)
	for _, num := range nums {
		record[num] = true
	}
	for key, value := range record {
		if value && key > 0 {
			ans += key
		}
		cur = max(cur, key)
	}
	if cur < 0 {
		ans = cur
	}
	return ans
}
