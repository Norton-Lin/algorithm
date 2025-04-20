package contest446

func CalculateScore(instructions []string, values []int) int64 {
	ans := int64(0)
	index := 0
	n := len(instructions)
	records := make(map[int]bool)
	for index >= 0 && index < n {
		if records[index] {
			break
		}
		records[index] = true
		if instructions[index] == "add" {
			ans += int64(values[index])
			index++
		} else {
			index += values[index]
		}
	}
	return ans
}
