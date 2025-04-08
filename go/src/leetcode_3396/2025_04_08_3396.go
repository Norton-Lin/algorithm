package main

func MinimumOperations(nums []int) int {
	ans := 0
	index := 0
	records := make([]int, 101)
	for _, num := range nums {
		records[num]++
	}
	for check(records) {
		ans++
		for i := 0; i < 3; i++ {
			records[nums[index]]--
			index++
		}
	}
	return ans
}

func check(records []int) (res bool) {
	res = true
	for _, record := range records {
		if record > 1 {
			res = false
			break
		}
	}
	return
}
