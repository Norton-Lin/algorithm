package main

func HasSameDigits(s string) bool {
	n := len(s)
	record := make([]int, n)
	for i := 0; i < n; i++ {
		record[i] = int(s[i] - 'a')
	}
	for count := n; count > 2; count-- {
		tmp := make([]int, n-1)
		for j := 0; j < count-1; j++ {
			tmp[j] = (record[j] + record[j+1]) % 10
		}
		for j := 0; j < n-1; j++ {
			record[j] = tmp[j]
		}
	}
	return record[0] == record[1]
}
