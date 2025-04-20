package contest446

func ResultArray(nums []int, k int) []int64 {
	result := make([]int64, k)
	prev := make(map[int]int)
	n := len(nums)
	for i := 0; i < n; i++ {
		nums[i] %= k
		cur := make(map[int]int)
		if nums[i] == 0 {
			pre := 0
			for _, v := range prev {
				pre += v
			}
			cur[0] = pre + 1
		} else {
			for t, v := range prev {
				key := (t * nums[i]) % k
				cur[key] += v
			}
			cur[nums[i]]++
		}
		prev = make(map[int]int)
		for t, v := range cur {
			prev[t] = v
			result[t] += int64(v)
		}
	}

	return result
}
