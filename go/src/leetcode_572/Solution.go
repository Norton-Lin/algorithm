/*
 * @lc app=leetcode.cn id=572 lang=golang
 *
 * [572] 另一棵树的子树
 */
package main

// @lc code=start

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
	return isTrue(root, subRoot, true)
}

func isTrue(root *TreeNode, subRoot *TreeNode, target bool) bool {
	ans := false
	if root == nil || subRoot == nil {
		return root == nil && subRoot == nil
	}
	if root.Val == subRoot.Val { //开始匹配，一旦开始匹配，就必须完全符合
		ans = isTrue(root.Left, subRoot.Left, false) && isTrue(root.Right, subRoot.Right, false)
	}
	if target { //没有开始匹配，向下找子树
		ans = ans || isTrue(root.Left, subRoot, true) || isTrue(root.Right, subRoot, true)
	}
	return ans
}

// @lc code=end
