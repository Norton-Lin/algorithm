package main

/*
 * @lc app=leetcode.cn id=3170 lang=golang
 *
 * [3170] 删除星号以后字典序最小的字符串
 */

// @lc code=start
// 每次删除 * 字符左侧最右的字典序最小字符
func ClearStars(s string) string {
	records := make([][]int, 26)
	ans := make([]rune, 0)
	n := len(s)
	tags := make([]bool, n)
	for i := 0; i < 26; i++ {
		records[i] = make([]int, 0)
	}
	cur := 'a'
	for i, c := range s {
		if c == '*' {
			l := len(records[cur-'a'])
			//fmt.Println(c,cur-'a',records,l)
			if l == 0 {
				cur = 'a'
			}
			for ; l == 0; cur++ {
				l = len(records[cur-'a'])
				//fmt.Println(cur-'a',l)
				if l > 0 {
					break
				}
			}
			//fmt.Println(cur-'a',l)
			tags[records[cur-'a'][l-1]] = true
			records[cur-'a'] = records[cur-'a'][0 : l-1]

		} else {
			if c < cur {
				cur = c
			}
			records[c-'a'] = append(records[c-'a'], i)
		}
	}
	for i, c := range s {
		if c == '*' || tags[i] {
			continue
		}
		ans = append(ans, c)
	}

	return string(ans)
}

// @lc code=end
