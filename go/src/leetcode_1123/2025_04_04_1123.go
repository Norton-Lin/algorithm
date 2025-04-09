package main

import "fmt"

/*
 * @lc app=leetcode.cn id=1123 lang=golang
 *
 * [1123] 最深叶节点的最近公共祖先
 */

// @lc code=start

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 如果有父节点，返回父节点,没有父节点，返回本节点
// 如果是单边树？
func LcaDeepestLeaves(root *TreeNode) *TreeNode {
	//depth := 0
	// 找深度
	var dfs func(root *TreeNode, cur int) int
	var dfs1 func(root *TreeNode, cur int) int
	var res *TreeNode
	depth := 0
	count := 0
	dfs = func(root *TreeNode, cur int) int {
		left, right := 0, 0
		//fmt.Println(root.Val,cur)
		if cur == depth {
			count++
			//fmt.Println(count)
		}
		if root.Left != nil {
			left = dfs(root.Left, cur+1)
		}
		if root.Right != nil {
			right = dfs(root.Right, cur+1)
		}
		return max(left, right) + 1
	}
	depth = dfs(root, 1)
	count = 0
	//fmt.Println(count,depth,0)
	dfs(root, 1)
	fmt.Println(count, depth)
	dfs1 = func(root *TreeNode, cur int) int {
		left, right := 0, 0
		ans := 0
		if root.Left != nil {
			left = dfs1(root.Left, cur+1)
		}
		if root.Right != nil {
			right = dfs1(root.Right, cur+1)
		}
		if cur == depth {
			ans = 1
		}
		ans += left + right
		if ans == count {
			res = root
			count = -1
		}
		return ans
	}
	dfs1(root, 1)
	return res
}

// @lc code=end
