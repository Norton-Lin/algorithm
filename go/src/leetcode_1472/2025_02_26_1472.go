package main

/*
 * @lc app=leetcode.cn id=1472 lang=golang
 *
 * [1472] 设计浏览器历史记录
 */

// @lc code=start
// 双栈
type BrowserHistory struct {
	front []string
	after []string
	cur   string
}

func Constructor(homepage string) BrowserHistory {
	return BrowserHistory{make([]string, 0), make([]string, 0), homepage}
}

func (t *BrowserHistory) Visit(url string) {
	t.front = t.front[0:0]
	t.after = append([]string{t.cur}, t.after...)
	t.cur = url
}

func (t *BrowserHistory) Back(steps int) string {
	if steps >= len(t.after) {
		steps = len(t.after)
	}
	steps--
	if steps < 0 {
		return t.cur
	}
	t.front = append([]string{t.cur}, t.front...)
	t.cur = t.after[steps]
	for _, url := range t.after[0:steps] {
		t.front = append([]string{url}, t.front...)
	}
	t.after = t.after[steps+1 : len(t.after)]
	return t.cur
}

func (t *BrowserHistory) Forward(steps int) string {
	if steps >= len(t.front) {
		steps = len(t.front)
	}
	steps--
	if steps < 0 {
		return t.cur
	}
	t.after = append([]string{t.cur}, t.after...)
	t.cur = t.front[steps]
	for _, url := range t.front[0:steps] {
		t.after = append([]string{url}, t.after...)
	}
	t.front = t.front[steps+1 : len(t.front)]
	return t.cur
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * obj := Constructor(homepage);
 * obj.Visit(url);
 * param_2 := obj.Back(steps);
 * param_3 := obj.Forward(steps);
 */
// @lc code=end
