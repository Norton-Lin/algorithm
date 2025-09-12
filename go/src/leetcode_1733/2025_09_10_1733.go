package main

/*
 * @lc app=leetcode.cn id=1733 lang=golang
 *
 * [1733] 需要教语言的最少人数
 */

// @lc code=start
func MinimumTeachings(n int, languages [][]int, friendships [][]int) int {
	setUser := make(map[int]struct{})
	for _, friendship := range friendships {
		setFriend := make(map[int]struct{})
		tag := false
		for _, lan := range languages[friendship[0]-1] {
			setFriend[lan] = struct{}{}
		}
		for _, lan := range languages[friendship[1]-1] {
			if _, ok := setFriend[lan]; ok {
				tag = true
				break
			}
		}
		if !tag {
			setUser[friendship[0]-1] = struct{}{}
			setUser[friendship[1]-1] = struct{}{}
		}
	}
	maxCnt := 0
	cnt := make([]int, n+1)
	for user := range setUser {
		for _, lan := range languages[user] {
			cnt[lan]++
			maxCnt = max(maxCnt, cnt[lan])
		}
	}
	return len(setUser) - maxCnt
}

// @lc code=end
