package main

// 杨辉三角plus 初始 122222222221
func HasSameDigits1(s string) bool {
	n := len(s)
	cur1 := int64(s[0] - 'a')
	cur2 := int64(s[n-1] - 'a')

	for i := 1; i < n; i++ {
		num := int64((int64(s[i]-'a') * int64(n-2) % 10) % 10)
		cur1 = int64((cur1 + num) % 10)
		cur2 = int64((cur2 + num) % 10)
	}
	return cur1%10 == cur2%10
}
