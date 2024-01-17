/*
 * @lc app=leetcode.cn id=2487 lang=java
 *
 * [2487] 从链表中移除节点
 */
package day.leetcode_2487;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// @lc code=start
class Solution {
    //如果后续有节点比当前节点大，移除当前节点
    //三指针，一个指向当前节点，一个指向头节点，一个遍历头结点到当前节点
    //单调栈
    public ListNode removeNodes(ListNode head) {
        //构建一个单调递减的链表
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = head.next;
        stack.push(head);
        while(cur!=null){
            while(!stack.isEmpty()&&cur.val>stack.peekLast().val){
                stack.pollLast();
            }
            if(stack.isEmpty())
                head = cur;
            else
                stack.peekLast().next = cur;
            stack.addLast(cur);;
            cur = cur.next;
        }
        stack.peekLast().next = null;
        return head;
    }
}
// @lc code=end
