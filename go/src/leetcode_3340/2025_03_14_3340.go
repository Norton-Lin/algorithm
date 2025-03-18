package main

func IsBalanced(num string) bool {
	ans := 0
	for i, num := range []byte(num) {
		if i%2 == 0 {
			ans += int(num)
		} else {
			ans -= int(num)
		}
	}
	return ans == 48 || ans == 0
}
