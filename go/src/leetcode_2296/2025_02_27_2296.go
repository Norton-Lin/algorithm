package main

/*
 * @lc app=leetcode.cn id=2296 lang=golang
 *
 * [2296] 设计一个文本编辑器
 */

// @lc code=start
// 双栈
type TextEditor struct {
	left  []byte
	right []byte
}

func Constructor() TextEditor {
	return TextEditor{}
}

func (t *TextEditor) AddText(text string) {
	t.left = append(t.left, text...)
}

func (t *TextEditor) DeleteText(k int) int {
	count := min(k, len(t.left))
	t.left = t.left[:len(t.left)-count]
	return count
}

func (t *TextEditor) CursorLeft(k int) string {
	move := min(k, len(t.left))
	for i := 0; i < move; i++ {
		t.right = append(t.right, t.left[len(t.left)-1])
		t.left = t.left[:len(t.left)-1]
	}
	return t.getLeftText()
}

func (t *TextEditor) CursorRight(k int) string {
	move := min(k, len(t.right))
	for i := 0; i < move; i++ {
		t.left = append(t.left, t.right[len(t.right)-1])
		t.right = t.right[:len(t.right)-1]
	}
	return t.getLeftText()
}

func (t *TextEditor) getLeftText() string {
	start := max(0, len(t.left)-10)
	return string(t.left[start:])
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddText(text);
 * param_2 := obj.DeleteText(k);
 * param_3 := obj.CursorLeft(k);
 * param_4 := obj.CursorRight(k);
 */
// @lc code=end
