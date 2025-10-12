package contestd167

func ScoreBalance(s string) bool {
	num1, num2 := 0, 0
	for _, c := range s {
		num1 += int(c - 'a' + 1)
	}
	for _, c := range s {
		num1 -= int(c - 'a' + 1)
		num2 += int(c - 'a' + 1)
		if num1 == num2 {
			return true
		}
	}
	return false
}
